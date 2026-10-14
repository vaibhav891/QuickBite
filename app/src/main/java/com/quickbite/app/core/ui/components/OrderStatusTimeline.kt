package com.quickbite.app.core.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.OutdoorGrill
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.quickbite.app.core.design.CoralPrimary
import com.quickbite.app.core.design.MintAccent
import com.quickbite.app.domain.model.OrderStatus

data class TimelineStep(
    val status: OrderStatus,
    val title: String,
    val subtitle: String,
    val icon: ImageVector
)

@Composable
fun OrderStatusTimeline(
    currentStatus: OrderStatus,
    modifier: Modifier = Modifier
) {
    val steps = listOf(
        TimelineStep(OrderStatus.PLACED, "Order Placed", "Payment authorized", Icons.Default.Receipt),
        TimelineStep(OrderStatus.ACCEPTED, "Order Accepted", "Restaurant confirmed", Icons.Default.CheckCircle),
        TimelineStep(OrderStatus.PREPARING, "Preparing Food", "Chef is cooking", Icons.Default.SoupKitchen),
        TimelineStep(OrderStatus.READY_FOR_PICKUP, "Ready for Pickup", "Packed at counter", Icons.Default.OutdoorGrill),
        TimelineStep(OrderStatus.PICKED_UP, "Out for Delivery", "Courier in transit", Icons.Default.DeliveryDining),
        TimelineStep(OrderStatus.DELIVERED, "Delivered", "Enjoy your meal!", Icons.Default.DoneAll)
    )

    if (currentStatus == OrderStatus.REJECTED || currentStatus == OrderStatus.CANCELLED) {
        Surface(
            modifier = modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.errorContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Cancel,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = if (currentStatus == OrderStatus.REJECTED) "Order Rejected" else "Order Cancelled",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                    Text(
                        text = "Refund has been automatically initiated.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onErrorContainer.copy(alpha = 0.8f)
                    )
                }
            }
        }
        return
    }

    Column(modifier = modifier.fillMaxWidth()) {
        steps.forEachIndexed { index, step ->
            val isCompleted = currentStatus.stepOrder > step.status.stepOrder
            val isCurrent = currentStatus.stepOrder == step.status.stepOrder
            val isUpcoming = currentStatus.stepOrder < step.status.stepOrder

            val indicatorColor by animateColorAsState(
                targetValue = when {
                    isCompleted -> MintAccent
                    isCurrent -> CoralPrimary
                    else -> MaterialTheme.colorScheme.outlineVariant
                },
                label = "indicatorColor"
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                // Left Column: Circle & Connecting Line
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(32.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(indicatorColor),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isCompleted) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        } else {
                            Icon(
                                imageVector = step.icon,
                                contentDescription = null,
                                tint = if (isCurrent) Color.White else MaterialTheme.colorScheme.outline,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }

                    // Connecting vertical line (unless last step)
                    if (index < steps.size - 1) {
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .height(32.dp)
                                .background(
                                    if (isCompleted) MintAccent else MaterialTheme.colorScheme.outlineVariant
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Right Column: Title and Subtitle
                Column(modifier = Modifier.padding(bottom = if (index < steps.size - 1) 16.dp else 0.dp)) {
                    Text(
                        text = step.title,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium
                        ),
                        color = when {
                            isCurrent -> CoralPrimary
                            isCompleted -> MaterialTheme.colorScheme.onSurface
                            else -> MaterialTheme.colorScheme.outline
                        }
                    )
                    Text(
                        text = step.subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (isCurrent || isCompleted) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}
