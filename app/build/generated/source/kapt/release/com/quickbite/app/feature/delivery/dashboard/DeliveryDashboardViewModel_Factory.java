package com.quickbite.app.feature.delivery.dashboard;

import com.quickbite.app.domain.repository.AuthRepository;
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
public final class DeliveryDashboardViewModel_Factory implements Factory<DeliveryDashboardViewModel> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<DeliveryRepository> deliveryRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public DeliveryDashboardViewModel_Factory(Provider<OrderRepository> orderRepositoryProvider,
      Provider<DeliveryRepository> deliveryRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.deliveryRepositoryProvider = deliveryRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public DeliveryDashboardViewModel get() {
    return newInstance(orderRepositoryProvider.get(), deliveryRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static DeliveryDashboardViewModel_Factory create(
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<DeliveryRepository> deliveryRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new DeliveryDashboardViewModel_Factory(orderRepositoryProvider, deliveryRepositoryProvider, authRepositoryProvider);
  }

  public static DeliveryDashboardViewModel newInstance(OrderRepository orderRepository,
      DeliveryRepository deliveryRepository, AuthRepository authRepository) {
    return new DeliveryDashboardViewModel(orderRepository, deliveryRepository, authRepository);
  }
}
