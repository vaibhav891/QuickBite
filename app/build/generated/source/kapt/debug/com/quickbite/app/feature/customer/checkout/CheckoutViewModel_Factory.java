package com.quickbite.app.feature.customer.checkout;

import com.quickbite.app.domain.repository.AuthRepository;
import com.quickbite.app.domain.repository.CartRepository;
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
public final class CheckoutViewModel_Factory implements Factory<CheckoutViewModel> {
  private final Provider<CartRepository> cartRepositoryProvider;

  private final Provider<OrderRepository> orderRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public CheckoutViewModel_Factory(Provider<CartRepository> cartRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.cartRepositoryProvider = cartRepositoryProvider;
    this.orderRepositoryProvider = orderRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public CheckoutViewModel get() {
    return newInstance(cartRepositoryProvider.get(), orderRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static CheckoutViewModel_Factory create(Provider<CartRepository> cartRepositoryProvider,
      Provider<OrderRepository> orderRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new CheckoutViewModel_Factory(cartRepositoryProvider, orderRepositoryProvider, authRepositoryProvider);
  }

  public static CheckoutViewModel newInstance(CartRepository cartRepository,
      OrderRepository orderRepository, AuthRepository authRepository) {
    return new CheckoutViewModel(cartRepository, orderRepository, authRepository);
  }
}
