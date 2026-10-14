package com.quickbite.app.feature.customer.details;

import androidx.lifecycle.SavedStateHandle;
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
public final class RestaurantDetailsViewModel_Factory implements Factory<RestaurantDetailsViewModel> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  private final Provider<RestaurantRepository> restaurantRepositoryProvider;

  private final Provider<CartRepository> cartRepositoryProvider;

  public RestaurantDetailsViewModel_Factory(Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<RestaurantRepository> restaurantRepositoryProvider,
      Provider<CartRepository> cartRepositoryProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
    this.restaurantRepositoryProvider = restaurantRepositoryProvider;
    this.cartRepositoryProvider = cartRepositoryProvider;
  }

  @Override
  public RestaurantDetailsViewModel get() {
    return newInstance(savedStateHandleProvider.get(), restaurantRepositoryProvider.get(), cartRepositoryProvider.get());
  }

  public static RestaurantDetailsViewModel_Factory create(
      Provider<SavedStateHandle> savedStateHandleProvider,
      Provider<RestaurantRepository> restaurantRepositoryProvider,
      Provider<CartRepository> cartRepositoryProvider) {
    return new RestaurantDetailsViewModel_Factory(savedStateHandleProvider, restaurantRepositoryProvider, cartRepositoryProvider);
  }

  public static RestaurantDetailsViewModel newInstance(SavedStateHandle savedStateHandle,
      RestaurantRepository restaurantRepository, CartRepository cartRepository) {
    return new RestaurantDetailsViewModel(savedStateHandle, restaurantRepository, cartRepository);
  }
}
