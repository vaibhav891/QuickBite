# QuickBite — Native Android Food Delivery Platform 🍔⚡

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84.svg?style=flat&logo=android)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Language-Kotlin%202.0-7F52FF.svg?style=flat&logo=kotlin)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20%7C%20Material%203-4285F4.svg?style=flat&logo=jetpackcompose)](https://developer.android.com/jetpack/compose)
[![Firebase](https://img.shields.io/badge/Backend-Firebase%20%7C%20Firestore%20%7C%20Cloud%20Functions-FFCA28.svg?style=flat&logo=firebase)](https://firebase.google.com/)
[![Stripe](https://img.shields.io/badge/Payments-Stripe%20Test%20Mode-635BFF.svg?style=flat&logo=stripe)](https://stripe.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

**QuickBite** is a native Android food delivery application crafted to demonstrate production-grade mobile engineering to prospective enterprise clients. Built exclusively with **Kotlin** and **Jetpack Compose (Material 3)**, QuickBite connects customers, restaurants, and delivery couriers through a unified backend powered by **Firebase Firestore**, **Cloud Functions (TypeScript)**, **Stripe Payments (Test Mode)**, and **Google Maps live simulation**.

---

## 📱 Screenshots & Visual Design

| Restaurant Discovery | Menu & Dish Details | Cart & Bill Breakdown |
|:---:|:---:|:---:|
| *(Featured spots, cuisine filter chips, delivery ETA)* | *(Category tabs, veg/non-veg dots, quantity steppers)* | *(Single restaurant guard, 5% GST, minor unit fees)* |

| Stripe Test Checkout | Live Order Tracking | Multi-Role Kitchen Dashboard |
|:---:|:---:|:---:|
| *(Stripe test cards, Demo QuickPay server verification)* | *(Moving courier marker on Google Map, live timeline)* | *(Incoming tickets, preparation stages, accept/reject)* |

---

## 🌟 Engineering Highlights

1. **Unidirectional Data Flow (UDF) & Clean MVVM**:
   - Every screen is backed by an immutable `UiState` exposed through Kotlin `StateFlow` and consumed via Compose `collectAsStateWithLifecycle()`.
   - Business logic is completely isolated from Composables; repositories decouple Android UI from Firebase and Network SDKs.

2. **Real-time Multi-Role Synchronization**:
   - Customer, Restaurant, and Delivery Partner interfaces observe the same Firestore documents.
   - When the restaurant accepts an order or the rider advances their route, the customer's live tracking screen updates reactively without polling or manual refreshes.

3. **Strict Server-Side State Machine & Audit Logging**:
   - Transitions follow an explicit state machine:
     `PLACED` → `ACCEPTED` → `PREPARING` → `READY_FOR_PICKUP` → `PICKED_UP` → `DELIVERED`.
   - Backend logic and Firestore rules disallow illegal state jumps or backwards transitions.
   - Every transition appends an immutable audit event to `orders/{orderId}/events` recording `actorId`, `timestamp`, `previousStatus`, `newStatus`, and notes.

4. **Authoritative Server-Side Price & Payment Validation**:
   - Client totals are strictly distrusted. The client submits only item IDs and quantities.
   - Cloud Functions query Firestore menu items, calculate minor units (paise), add 5% GST and delivery fees, create the Stripe `PaymentIntent`, and verify payment prior to order creation.

5. **Deterministic Simulated Courier Tracking**:
   - Courier route updates follow 10 realistic GPS waypoints from the restaurant to the customer's delivery destination.
   - Controlled via both manual "Step Route" triggers (for deterministic client demos) and automatic 3-second interval loops without consuming continuous background GPS.

---

## 🏗️ System Architecture

```
QuickBite Android Client (Kotlin / Compose / Hilt)
  ├── Presentation Layer (Composables, ViewModels, Theme)
  ├── Domain Layer (Models, Repositories Interfaces, UseCases)
  └── Data Layer (Repositories, Seed Data, In-Memory Fallbacks)
          │
          ├── Real-time Flow Listeners
          ▼
Cloud Firestore Realtime Database
  ├── /restaurants/{restaurantId}
  ├── /restaurants/{restaurantId}/menuItems/{itemId}
  ├── /orders/{orderId}
  │     └── /events/{eventId} (Immutable Audit Log)
  ├── /deliveries/{deliveryId} (Telemetry & Waypoints)
  └── /users/{userId}
          ▲
          ├── Auth & State Validation
          │
Firebase Cloud Functions (TypeScript)
  ├── createPaymentIntent (Server-side price recalculation)
  ├── confirmOrder (Stripe payment verification & order placement)
  ├── updateOrderStatus (State machine validation & FCM dispatch)
  └── updateDeliveryLocation (Route waypoint advancement)
          │
          └── Test Mode API
          ▼
Stripe Payments Engine (Test Mode)
```

---

## 🛠️ Technology Stack

| Layer | Technologies |
|---|---|
| **Language** | Kotlin 2.0.20 |
| **UI Toolkit** | Jetpack Compose (Compose BOM 2024.09.00), Material 3 1.2.1 |
| **Architecture** | MVVM, Unidirectional Data Flow, Repository Pattern |
| **Dependency Injection** | Hilt 2.51.1 (`dagger.hilt.android`) |
| **Asynchronous & Reactive** | Kotlin Coroutines, StateFlow, SharedFlow |
| **Backend & Cloud** | Firebase Auth, Cloud Firestore, Cloud Functions (Node 20 / TypeScript), Cloud Messaging |
| **Payments** | Stripe Android SDK (`com.stripe:stripe-android:20.48.4`) |
| **Maps & Telemetry** | Google Maps SDK for Android (`play-services-maps:18.2.0`), Maps Compose (`4.4.1`) |
| **Image Loading** | Coil Compose 2.7.0 with crossfade and caching |
| **Testing** | JUnit 4, MockK, Compose UI Test (`ui-test-junit4`) |

---

## 🔄 Order Lifecycle State Machine

```
              ┌───────────────┐
              │    PLACED     │
              └───────┬───────┘
                      │
        ┌─────────────┴─────────────┐
        ▼                           ▼
┌───────────────┐           ┌───────────────┐
│   ACCEPTED    │           │   REJECTED    │ (Terminal)
└───────┬───────┘           └───────────────┘
        ▼
┌───────────────┐
│   PREPARING   │
└───────┬───────┘
        ▼
┌──────────────────┐
│ READY_FOR_PICKUP │ (Eligible for couriers to claim)
└───────┬──────────┘
        ▼
┌───────────────┐
│   PICKED_UP   │ (Simulated telemetry active)
└───────┬───────┘
        ▼
┌───────────────┐
│   DELIVERED   │ (Terminal)
└───────────────┘
```

---

## 💳 Stripe Test-Mode Payment Flow

1. Customer taps **"Proceed to Pay"** in checkout.
2. Android client calls Cloud Function `createPaymentIntent` with items and delivery address.
3. Server queries `restaurants/{id}/menuItems` and computes the exact subtotal, 5% GST, and delivery fee in minor units (paise). Client totals are ignored.
4. Server creates a Stripe `PaymentIntent` and returns `clientSecret` and `orderDraftId`.
5. The Android app presents the native Stripe `PaymentSheet` (or verifies via "Demo QuickPay").
6. Server verifies payment status directly with Stripe before recording the order in Firestore.

---

## 🚀 One-App Multi-Role Demo Mode

QuickBite features a built-in **Demo Role Selector** located at the top of every screen:

| Role | Seeded Identity | Capabilities |
|---|---|---|
| **Customer** | `demo_customer_01` (Vaibhav Sultania) | Browse restaurants, add items to cart, checkout with Stripe test mode, track moving courier on Google Maps |
| **Restaurant** | `rest_01` (Golden Dragon Asian Bistro) | Manage live kitchen queue, accept/reject incoming orders with reason, mark preparing, mark ready for pickup |
| **Delivery Partner** | `demo_rider_01` (Alex Rivera) | Claim unassigned orders, confirm pickup, advance GPS route step-by-step or auto-run, mark delivered |

---

## 🧪 Testing Strategy & Results

QuickBite includes focused unit test suites covering the core financial calculations, state transitions, and simulation logic:

- **CartCalculationTest**:
  - `testEmptyCartInitialState`: Verifies zero totals and empty state.
  - `testAddItemCalculatesSubtotalTaxAndTotalAccurately`: Verifies minor unit addition, 5% GST rounding, and delivery fees.
  - `testIncreasingQuantityUpdatesTotalsProperly`: Verifies quantity multiplication.
  - `testMultipleDistinctItemsCalculation`: Multi-item summation.
  - `testSingleRestaurantRestrictionEnforced`: Rejects mixing dishes from different restaurants.
  - `testDecreasingQuantityToZeroRemovesItem`: Auto-removes item upon zero quantity.
- **OrderStateMachineTest**:
  - `testValidHappyPathOrderLifecycleProgression`: Verifies `PLACED` → `ACCEPTED` → `PREPARING` → `READY_FOR_PICKUP` → `PICKED_UP` → `DELIVERED`.
  - `testOrderRejectionAndCancellationTransitions`: Validates rejection states.
  - `testInvalidTransitionsAreDisallowed`: Guards against skipping states or reversing status.
- **SimulatedLocationEngineTest**:
  - Verifies waypoint bounds, bearing angle calculation, and manual step progression.
- **CurrencyUtilsTest**:
  - Verifies INR formatting (`₹49`, `₹380`) and 5% tax rounding.

### Test Execution Command
```bash
./gradlew testDebugUnitTest
```
**Results**: `15 tests completed, 0 failures, 0 errors, BUILD SUCCESSFUL`.

---

## 📦 Build & Run Instructions

### Prerequisites
- JDK 21 (configured in `JAVA_HOME`)
- Android SDK 34 (configured in `local.properties`)
- Node.js 20+ (for Firebase Functions)

### 1. Clone & Build Debug APK
```bash
# Build the native Android debug APK
./gradlew assembleDebug

# Output APK location:
# app/build/outputs/apk/debug/app-debug.apk
```

### 2. Install on Device or Emulator
```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### 3. Build & Emulate Firebase Backend (Optional)
```bash
cd functions
npm install
npm run build

# Start Firebase local emulators
firebase emulators:start
```

---

## 🎭 Prospective Client Walkthrough Script

Follow these steps to demonstrate the end-to-end food delivery workflow in under 3 minutes:

1. **Launch QuickBite**:
   - The app opens on **Restaurant Discovery** in **Customer** mode.
   - Tap **"Golden Dragon Asian Bistro"** or filter by cuisine ("Pan-Asian", "Wood-fired Pizza").
2. **Add Items to Cart**:
   - Tap **"ADD"** on *Steamed Crystal Shrimp Dumplings* and *Sichuan Dan Dan Noodles*.
   - Notice the floating green cart bar appears with live count and total. Tap **"View Cart"**.
3. **Checkout**:
   - Inspect the itemized bill (Subtotal, Delivery Fee ₹49, 5% GST, Grand Total).
   - Tap **"Proceed to Pay"**.
   - Select **"Demo QuickPay"** (or Stripe Test Card) and tap **"Pay & Place Order"**.
4. **Live Order Tracking**:
   - You are immediately redirected to **Live Order Tracking**.
   - Note the order number (e.g. `QB-104928`) and the status: `"Order Placed"`.
5. **Switch to Restaurant Role**:
   - At the top bar, tap the **"Restaurant"** chip.
   - The screen transitions to the **Kitchen Dashboard** for *Golden Dragon Asian Bistro*.
   - Tap the **"New"** tab. The placed order is waiting!
   - Tap **"Accept Order"** → status transitions to `ACCEPTED`.
   - Tap **"Start Food Preparation"** → status transitions to `PREPARING`.
   - Tap **"Mark Ready for Pickup"** → status transitions to `READY_FOR_PICKUP`.
6. **Switch to Delivery Partner Role**:
   - At the top bar, tap the **"Delivery Partner"** chip.
   - Under **"Available"**, the order appears ready for pickup.
   - Tap **"Claim Delivery"** → transitions to **"Assigned to Me"**.
   - Tap **"Confirm Food Picked Up"** → status transitions to `PICKED_UP`.
   - Tap **"Step Route"** or **"Auto Run"** to simulate the courier vehicle moving along city streets.
7. **Switch back to Customer Role**:
   - Tap **"Customer"** in the top bar.
   - Open **Orders** → Tap **"Track Live Order"**.
   - The Google Map shows the courier actively moving along the route, with ETA and live timeline in sync!
8. **Complete Delivery**:
   - Switch to Rider → tap **"Mark as Delivered"**.
   - The customer's tracking screen immediately displays **"Delivered — Enjoy your meal!"**.

---

## 🔒 Security & Data Rules Summary

- **Firestore Rules (`firestore.rules`)**:
  - Customers can read only their own orders (`customerId == request.auth.uid`).
  - Restaurants can read orders placed with their restaurant ID.
  - Delivery riders can claim only unassigned orders and update only assigned shipments.
  - Audit logs are append-only; update/delete operations are rejected.
- **Server-side Validation**:
  - Menu item prices, availability, quantities, and taxes are strictly verified on the server before payment intents are issued.

---

## 📄 License
This project is released under the [MIT License](LICENSE).
