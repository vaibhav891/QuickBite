package com.quickbite.app.feature.customer.discovery;

import com.quickbite.app.domain.repository.CartRepository;
import com.quickbite.app.domain.repository.RestaurantRepository;
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
public final class RestaurantDiscoveryViewModel_Factory implements Factory<RestaurantDiscoveryViewModel> {
  private final Provider<RestaurantRepository> restaurantRepositoryProvider;

  private final Provider<CartRepository> cartRepositoryProvider;

  public RestaurantDiscoveryViewModel_Factory(
      Provider<RestaurantRepository> restaurantRepositoryProvider,
      Provider<CartRepository> cartRepositoryProvider) {
    this.restaurantRepositoryProvider = restaurantRepositoryProvider;
    this.cartRepositoryProvider = cartRepositoryProvider;
  }

  @Override
  public RestaurantDiscoveryViewModel get() {
    return newInstance(restaurantRepositoryProvider.get(), cartRepositoryProvider.get());
  }

  public static RestaurantDiscoveryViewModel_Factory create(
      Provider<RestaurantRepository> restaurantRepositoryProvider,
      Provider<CartRepository> cartRepositoryProvider) {
    return new RestaurantDiscoveryViewModel_Factory(restaurantRepositoryProvider, cartRepositoryProvider);
  }

  public static RestaurantDiscoveryViewModel newInstance(RestaurantRepository restaurantRepository,
      CartRepository cartRepository) {
    return new RestaurantDiscoveryViewModel(restaurantRepository, cartRepository);
  }
}
