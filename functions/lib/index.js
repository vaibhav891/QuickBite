"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.updateDeliveryLocation = exports.updateOrderStatus = exports.confirmOrder = exports.createPaymentIntent = void 0;
const functions = require("firebase-functions");
const admin = require("firebase-admin");
const stripe_1 = require("stripe");
admin.initializeApp();
const db = admin.firestore();
// Initialize Stripe with secret key or mock fallback
const stripeKey = process.env.STRIPE_SECRET_KEY || "sk_test_mock_quickbite_demo_secret_key";
const stripe = new stripe_1.default(stripeKey, {
    apiVersion: "2024-06-20",
});
/**
 * Valid state transitions for order lifecycle
 */
const ALLOWED_TRANSITIONS = {
    PLACED: ["ACCEPTED", "REJECTED", "CANCELLED"],
    ACCEPTED: ["PREPARING", "CANCELLED"],
    PREPARING: ["READY_FOR_PICKUP"],
    READY_FOR_PICKUP: ["PICKED_UP"],
    PICKED_UP: ["DELIVERED"],
    REJECTED: [],
    CANCELLED: [],
    DELIVERED: [],
};
// Cloud Functions region: Asia Pacific - Mumbai (asia-south1)
const REGION = "asia-south1";
const regionalFunctions = functions
    .region(REGION)
    .runWith({
    serviceAccount: "quickbite-83328@appspot.gserviceaccount.com",
});
/**
 * Callable Function: Create PaymentIntent with Server-Side Price Validation
 */
exports.createPaymentIntent = regionalFunctions.https.onCall(async (data, context) => {
    if (!context.auth) {
        throw new functions.https.HttpsError("unauthenticated", "User must be authenticated to check out.");
    }
    const { restaurantId, items, deliveryAddress } = data;
    if (!restaurantId || !Array.isArray(items) || items.length === 0) {
        throw new functions.https.HttpsError("invalid-argument", "Valid restaurant ID and cart items are required.");
    }
    // 1. Fetch restaurant data to verify delivery fee & existence
    const restDoc = await db.collection("restaurants").doc(restaurantId).get();
    if (!restDoc.exists) {
        throw new functions.https.HttpsError("not-found", "Restaurant does not exist.");
    }
    const restaurantData = restDoc.data();
    const deliveryFeeMinor = restaurantData.deliveryFeeMinor || 4900; // ₹49.00 default in paise
    // 2. Authoritative price recalculation from Firestore menu items
    let subtotalMinor = 0;
    const verifiedOrderItems = [];
    for (const cartItem of items) {
        const itemDoc = await db
            .collection("restaurants")
            .doc(restaurantId)
            .collection("menuItems")
            .doc(cartItem.itemId)
            .get();
        if (!itemDoc.exists) {
            throw new functions.https.HttpsError("not-found", `Menu item ${cartItem.itemId} is no longer available.`);
        }
        const itemData = itemDoc.data();
        if (itemData.isAvailable === false) {
            throw new functions.https.HttpsError("failed-precondition", `${itemData.name} is currently out of stock.`);
        }
        const quantity = Math.max(1, Math.min(20, Math.floor(cartItem.quantity || 1)));
        const unitPriceMinor = itemData.priceMinor;
        const itemTotalMinor = unitPriceMinor * quantity;
        subtotalMinor += itemTotalMinor;
        verifiedOrderItems.push({
            itemId: cartItem.itemId,
            name: itemData.name,
            quantity,
            unitPriceMinor,
            totalPriceMinor: itemTotalMinor,
        });
    }
    // Calculate 5% GST/Tax in minor units
    const taxMinor = Math.round(subtotalMinor * 0.05);
    const totalMinor = subtotalMinor + deliveryFeeMinor + taxMinor;
    // 3. Create Stripe PaymentIntent (or test mock secret)
    let clientSecret;
    let paymentIntentId;
    if (process.env.STRIPE_SECRET_KEY && !process.env.STRIPE_SECRET_KEY.includes("mock")) {
        const paymentIntent = await stripe.paymentIntents.create({
            amount: totalMinor,
            currency: "inr",
            payment_method_types: ["card"],
            metadata: {
                customerId: context.auth.uid,
                restaurantId,
                verifiedItemCount: verifiedOrderItems.length.toString(),
            },
        });
        clientSecret = paymentIntent.client_secret || "";
        paymentIntentId = paymentIntent.id;
    }
    else {
        // Deterministic test secret for mock Stripe flow
        paymentIntentId = `pi_demo_${Date.now()}`;
        clientSecret = `pi_demo_${Date.now()}_secret_${Math.random().toString(36).substring(2, 9)}`;
    }
    // Create order draft in Firestore with 15-minute TTL
    const orderDraftRef = db.collection("orderDrafts").doc();
    await orderDraftRef.set({
        draftId: orderDraftRef.id,
        customerId: context.auth.uid,
        restaurantId,
        restaurantName: restaurantData.name,
        items: verifiedOrderItems,
        deliveryAddress: deliveryAddress || "221B Baker Street, Floor 3, Mumbai",
        subtotalMinor,
        deliveryFeeMinor,
        taxMinor,
        totalMinor,
        currency: "INR",
        paymentIntentId,
        clientSecret,
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
    });
    return {
        orderDraftId: orderDraftRef.id,
        paymentIntentId,
        clientSecret,
        subtotalMinor,
        deliveryFeeMinor,
        taxMinor,
        totalMinor,
        currency: "INR",
    };
});
/**
 * Callable Function: Confirm Order Creation after Payment
 */
exports.confirmOrder = regionalFunctions.https.onCall(async (data, context) => {
    if (!context.auth) {
        throw new functions.https.HttpsError("unauthenticated", "User must be authenticated.");
    }
    const { orderDraftId, paymentIntentId, isMockPayment } = data;
    if (!orderDraftId) {
        throw new functions.https.HttpsError("invalid-argument", "Missing orderDraftId.");
    }
    const draftDoc = await db.collection("orderDrafts").doc(orderDraftId).get();
    if (!draftDoc.exists) {
        throw new functions.https.HttpsError("not-found", "Order draft expired or not found.");
    }
    const draft = draftDoc.data();
    if (draft.customerId !== context.auth.uid) {
        throw new functions.https.HttpsError("permission-denied", "Order draft belongs to another user.");
    }
    // Verify payment if real Stripe is active and not explicit mock test mode
    if (!isMockPayment && process.env.STRIPE_SECRET_KEY && !process.env.STRIPE_SECRET_KEY.includes("mock")) {
        const paymentIntent = await stripe.paymentIntents.retrieve(paymentIntentId || draft.paymentIntentId);
        if (paymentIntent.status !== "succeeded") {
            throw new functions.https.HttpsError("failed-precondition", `Payment status is ${paymentIntent.status}. Order not created.`);
        }
    }
    // Create authoritative Order record
    const orderRef = db.collection("orders").doc();
    const orderId = orderRef.id;
    const now = admin.firestore.FieldValue.serverTimestamp();
    const newOrder = {
        orderId,
        orderNumber: `QB-${Math.floor(100000 + Math.random() * 900000)}`,
        customerId: draft.customerId,
        customerName: context.auth.token.name || "Alex Johnson",
        restaurantId: draft.restaurantId,
        restaurantName: draft.restaurantName,
        deliveryPartnerId: null,
        deliveryPartnerName: null,
        items: draft.items,
        deliveryAddress: draft.deliveryAddress,
        subtotalMinor: draft.subtotalMinor,
        deliveryFeeMinor: draft.deliveryFeeMinor,
        taxMinor: draft.taxMinor,
        totalMinor: draft.totalMinor,
        currency: draft.currency || "INR",
        paymentStatus: "PAID",
        paymentIntentId: draft.paymentIntentId,
        paymentMethod: isMockPayment ? "TEST_MODE_QUICKPAY" : "STRIPE_TEST_CARD",
        status: "PLACED",
        createdAt: now,
        updatedAt: now,
        estimatedDeliveryMinutes: 30,
    };
    await orderRef.set(newOrder);
    // Initial event log
    await orderRef.collection("events").add({
        eventId: `ev_${Date.now()}`,
        orderId,
        previousStatus: null,
        newStatus: "PLACED",
        actorId: context.auth.uid,
        actorRole: "CUSTOMER",
        timestamp: now,
        note: "Order placed and verified by server.",
    });
    // Create delivery document for tracking
    await db.collection("deliveries").doc(orderId).set({
        orderId,
        deliveryPartnerId: null,
        status: "UNASSIGNED",
        currentLatitude: 19.0760, // Mumbai Downtown default
        currentLongitude: 72.8777,
        routeProgressPercent: 0,
        currentStepIndex: 0,
        totalSteps: 10,
        updatedAt: now,
    });
    // Remove draft after successful placement
    await draftDoc.ref.delete();
    return {
        orderId,
        orderNumber: newOrder.orderNumber,
        status: "PLACED",
        totalMinor: newOrder.totalMinor,
    };
});
/**
 * Callable Function: Update Order Status (Enforces Centralized State Machine)
 */
exports.updateOrderStatus = regionalFunctions.https.onCall(async (data, context) => {
    if (!context.auth) {
        throw new functions.https.HttpsError("unauthenticated", "Authentication required.");
    }
    const { orderId, newStatus, note, rejectReason } = data;
    if (!orderId || !newStatus) {
        throw new functions.https.HttpsError("invalid-argument", "orderId and newStatus are required.");
    }
    const orderRef = db.collection("orders").doc(orderId);
    const orderDoc = await orderRef.get();
    if (!orderDoc.exists) {
        throw new functions.https.HttpsError("not-found", "Order not found.");
    }
    const order = orderDoc.data();
    const currentStatus = order.status;
    // Validate state machine rules
    const allowed = ALLOWED_TRANSITIONS[currentStatus] || [];
    if (!allowed.includes(newStatus)) {
        throw new functions.https.HttpsError("failed-precondition", `Invalid transition: cannot change order status from ${currentStatus} to ${newStatus}.`);
    }
    const callerUid = context.auth.uid;
    const userRole = context.auth.token.role || "customer";
    // Role authorization checks
    if (["ACCEPTED", "PREPARING", "READY_FOR_PICKUP", "REJECTED"].includes(newStatus)) {
        // Only restaurant owner or admin can advance these states
        if (order.restaurantId !== callerUid && userRole !== "restaurant" && userRole !== "admin") {
            throw new functions.https.HttpsError("permission-denied", "Only the assigned restaurant can perform this action.");
        }
    }
    else if (["PICKED_UP", "DELIVERED"].includes(newStatus)) {
        // Only delivery partner assigned or claiming can advance
        if (order.deliveryPartnerId && order.deliveryPartnerId !== callerUid && userRole !== "admin") {
            throw new functions.https.HttpsError("permission-denied", "Only the assigned delivery partner can update this.");
        }
    }
    const now = admin.firestore.FieldValue.serverTimestamp();
    const updateData = {
        status: newStatus,
        updatedAt: now,
    };
    if (newStatus === "REJECTED" && rejectReason) {
        updateData.rejectReason = rejectReason;
    }
    await orderRef.update(updateData);
    // Append audit event
    await orderRef.collection("events").add({
        eventId: `ev_${Date.now()}`,
        orderId,
        previousStatus: currentStatus,
        newStatus,
        actorId: callerUid,
        actorRole: userRole.toUpperCase(),
        timestamp: now,
        note: note || (newStatus === "REJECTED" ? rejectReason : `Order transitioned to ${newStatus}`),
    });
    // Keep delivery doc in sync
    if (newStatus === "READY_FOR_PICKUP") {
        await db.collection("deliveries").doc(orderId).update({
            status: "READY_FOR_PICKUP",
            updatedAt: now,
        });
    }
    else if (newStatus === "PICKED_UP") {
        await db.collection("deliveries").doc(orderId).update({
            status: "IN_TRANSIT",
            deliveryPartnerId: callerUid,
            updatedAt: now,
        });
    }
    else if (newStatus === "DELIVERED") {
        await db.collection("deliveries").doc(orderId).update({
            status: "DELIVERED",
            routeProgressPercent: 100,
            updatedAt: now,
        });
    }
    // Send Push Notification via FCM to Customer
    try {
        const userDoc = await db.collection("users").doc(order.customerId).get();
        const fcmToken = userDoc.data()?.fcmToken;
        if (fcmToken) {
            const messages = {
                ACCEPTED: {
                    title: "Order Accepted! 🍳",
                    body: `${order.restaurantName} has accepted your order #${order.orderNumber}.`,
                },
                PREPARING: {
                    title: "Food is being prepared! 🥗",
                    body: `Chef at ${order.restaurantName} is preparing your food.`,
                },
                READY_FOR_PICKUP: {
                    title: "Ready for Pickup! 🛵",
                    body: "Your order is packed and waiting for the delivery partner.",
                },
                PICKED_UP: {
                    title: "On the way! ⚡",
                    body: "Your delivery partner has picked up your order and is heading your way.",
                },
                DELIVERED: {
                    title: "Order Delivered! 🎉",
                    body: "Your order has been delivered. Enjoy your meal!",
                },
                REJECTED: {
                    title: "Order Update",
                    body: `Unfortunately, ${order.restaurantName} could not fulfill your order.`,
                },
            };
            const msg = messages[newStatus];
            if (msg) {
                await admin.messaging().send({
                    token: fcmToken,
                    notification: {
                        title: msg.title,
                        body: msg.body,
                    },
                    data: {
                        orderId,
                        status: newStatus,
                    },
                });
            }
        }
    }
    catch (err) {
        console.warn("FCM notification sending failed or skipped (no token):", err);
    }
    return { success: true, orderId, status: newStatus };
});
/**
 * Callable Function: Update Delivery Location (Simulation Step)
 */
exports.updateDeliveryLocation = regionalFunctions.https.onCall(async (data, context) => {
    if (!context.auth) {
        throw new functions.https.HttpsError("unauthenticated", "Authentication required.");
    }
    const { orderId, latitude, longitude, stepIndex, totalSteps, progressPercent } = data;
    if (!orderId || latitude === undefined || longitude === undefined) {
        throw new functions.https.HttpsError("invalid-argument", "Missing coordinates or orderId.");
    }
    const deliveryRef = db.collection("deliveries").doc(orderId);
    const now = admin.firestore.FieldValue.serverTimestamp();
    await deliveryRef.update({
        currentLatitude: latitude,
        currentLongitude: longitude,
        currentStepIndex: stepIndex || 0,
        totalSteps: totalSteps || 10,
        routeProgressPercent: progressPercent || 0,
        updatedAt: now,
    });
    return { success: true, orderId, latitude, longitude };
});
//# sourceMappingURL=index.js.map