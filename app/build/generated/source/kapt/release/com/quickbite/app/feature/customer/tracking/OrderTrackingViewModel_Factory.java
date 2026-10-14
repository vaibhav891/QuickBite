package com.quickbite.app.feature.customer.tracking;

import androidx.lifecycle.SavedStateHandle;
import com.quickbite.app.domain.repository.DeliveryRepository;
import com.quickbite.app.domain.repository.OrderRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class OrderTrackingViewModel_Factory implements Factory<OrderTrackingViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<DeliveryRepository> deliveryRepositoryProvider;

  public OrderTrackingViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<DeliveryRepository> deliveryRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.deliveryRepositoryProvider = deliveryRepositoryProvider;
  }

  @Override
  public OrderTrackingViewModel get() {
    return newInstance(savedStateHandleProvider.get(), orderRepositoryProvider.get(), deliveryRepositoryProvider.get());
  }

  public static OrderTrackingViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<DeliveryRepository> deliveryRepositoryProvider) {
    return new OrderTrackingViewModel_Factory(savedStateHandleProvider, orderRepositoryProvider, deliveryRepositoryProvider);
  }

  public static OrderTrackingViewModel newInstance(SavedStateHandle savedStateHandle,
      OrderRepository orderRepository, DeliveryRepository deliveryRepository) {
    return new OrderTrackingViewModel(savedStateHandle, orderRepository, deliveryRepository);
  }
}
