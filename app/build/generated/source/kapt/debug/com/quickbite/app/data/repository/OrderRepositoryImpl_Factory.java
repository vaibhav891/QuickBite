package com.quickbite.app.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.functions.FirebaseFunctions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class OrderRepositoryImpl_Factory implements Factory<OrderRepositoryImpl> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseFunctions> functionsProvider;

  public OrderRepositoryImpl_Factory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseFunctions> functionsProvider) {
    this.firestoreProvider = firestoreProvider;
    this.functionsProvider = functionsProvider;
  }

  @Override
  public OrderRepositoryImpl get() {
    return newInstance(firestoreProvider.get(), functionsProvider.get());
  }

  public static OrderRepositoryImpl_Factory create(Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseFunctions> functionsProvider) {
    return new OrderRepositoryImpl_Factory(firestoreProvider, functionsProvider);
  }

  public static OrderRepositoryImpl newInstance(FirebaseFirestore firestore,
      FirebaseFunctions functions) {
    return new OrderRepositoryImpl(firestore, functions);
  }
}
