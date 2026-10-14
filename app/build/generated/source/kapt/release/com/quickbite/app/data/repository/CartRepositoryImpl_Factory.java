package com.quickbite.app.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class CartRepositoryImpl_Factory implements Factory<CartRepositoryImpl> {
  @Override
  public CartRepositoryImpl get() {
    return newInstance();
  }

  public static CartRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CartRepositoryImpl newInstance() {
    return new CartRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final CartRepositoryImpl_Factory INSTANCE = new CartRepositoryImpl_Factory();
  }
}
