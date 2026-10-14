package com.quickbite.app.feature.customer.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quickbite.app.core.design.CoralPrimary
import com.quickbite.app.core.design.MintAccent
import com.quickbite.app.core.design.StatusPlaced
import com.quickbite.app.core.ui.components.EmptyStateView
import com.quickbite.app.core.ui.components.LoadingView
import com.quickbite.app.core.ui.components.QuickBiteButton
import com.quickbite.app.domain.model.Order
import com.quickbite.app.domain.model.OrderStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderHistoryScreen(
    viewModel: OrderHistoryViewModel,
    onTrackOrderClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Order History",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        if (uiState.isLoading) {
            LoadingView(message = "Loading your past orders...")
        } else if (uiState.activeOrders.isEmpty() && uiState.pastOrders.isEmpty()) {
            EmptyStateView(
                icon = Icons.Default.History,
                title = "No orders yet",
                subtitle = "When you place food orders, they will appear here in real-time.",
                modifier = Modifier.padding(padding)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Active Orders Section
                if (uiState.activeOrders.isNotEmpty()) {
                    item {
                        Text(
                            text = "ACTIVE ORDERS",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = CoralPrimary
                        )
                    }
                    items(uiState.activeOrders, key = { it.orderId }) { order ->
                        OrderCard(order = order, onTrackClick = { onTrackOrderClick(order.orderId) })
                    }
                }

                // Past Orders Section
                if (uiState.pastOrders.isNotEmpty()) {
                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "PAST ORDERS",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                    items(uiState.pastOrders, key = { it.orderId }) { order ->
                        OrderCard(order = order, onTrackClick = { onTrackOrderClick(order.orderId) })
                    }
                }
            }
        }
    }
}

@Composable
private fun OrderCard(
    order: Order,
    onTrackClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onTrackClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = order.restaurantName,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = order.orderNumber,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }

                OrderStatusPill(status = order.status)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "${order.totalItemCount} items • ${order.formattedTotal}",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
            )

            if (!order.status.isTerminal()) {
                HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                QuickBiteButton(
                    text = "Track Live Order →",
                    onClick = onTrackClick,
                    modifier = Modifier.height(44.dp)
                )
            }
        }
    }
}

@Composable
private fun OrderStatusPill(status: OrderStatus) {
    val (bgColor, textColor) = when (status) {
        OrderStatus.PLACED -> Pair(StatusPlaced.copy(alpha = 0.15f), StatusPlaced)
        OrderStatus.ACCEPTED -> Pair(CoralPrimary.copy(alpha = 0.15f), CoralPrimary)
        OrderStatus.PREPARING -> Pair(Color(0xFFF59E0B).copy(alpha = 0.15f), Color(0xFFF59E0B))
        OrderStatus.READY_FOR_PICKUP -> Pair(MintAccent.copy(alpha = 0.15f), MintAccent)
        OrderStatus.PICKED_UP -> Pair(CoralPrimary.copy(alpha = 0.15f), CoralPrimary)
        OrderStatus.DELIVERED -> Pair(Color(0xFF10B981).copy(alpha = 0.15f), Color(0xFF10B981))
        OrderStatus.REJECTED, OrderStatus.CANCELLED -> Pair(MaterialTheme.colorScheme.errorContainer, MaterialTheme.colorScheme.error)
    }

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = bgColor
    ) {
        Text(
            text = status.displayName,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
            color = textColor,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}
