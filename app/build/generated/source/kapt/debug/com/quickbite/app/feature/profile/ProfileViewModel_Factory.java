package com.quickbite.app.feature.profile;

import com.quickbite.app.domain.repository.AuthRepository;
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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<RestaurantRepository> restaurantRepositoryProvider;

  public ProfileViewModel_Factory(Provider<AuthRepository> authRepositoryProvider,
      Provider<RestaurantRepository> restaurantRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
    this.restaurantRepositoryProvider = restaurantRepositoryProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(authRepositoryProvider.get(), restaurantRepositoryProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider,
      Provider<RestaurantRepository> restaurantRepositoryProvider) {
    return new ProfileViewModel_Factory(authRepositoryProvider, restaurantRepositoryProvider);
  }

  public static ProfileViewModel newInstance(AuthRepository authRepository,
      RestaurantRepository restaurantRepository) {
    return new ProfileViewModel(authRepository, restaurantRepository);
  }
}
