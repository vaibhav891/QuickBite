package com.quickbite.app.feature.customer.history;

import com.quickbite.app.domain.repository.AuthRepository;
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
public final class OrderHistoryViewModel_Factory implements Factory<OrderHistoryViewModel> {
  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public OrderHistoryViewModel_Factory(Provider<OrderRepository> orderRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public OrderHistoryViewModel get() {
    return newInstance(orderRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static OrderHistoryViewModel_Factory create(
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new OrderHistoryViewModel_Factory(orderRepositoryProvider, authRepositoryProvider);
  }

  public static OrderHistoryViewModel newInstance(OrderRepository orderRepository,
      AuthRepository authRepository) {
    return new OrderHistoryViewModel(orderRepository, authRepository);
  }
}
