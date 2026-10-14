package com.quickbite.app.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import com.quickbite.app.core.location.SimulatedLocationEngine;
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
public final class DeliveryRepositoryImpl_Factory implements Factory<DeliveryRepositoryImpl> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<SimulatedLocationEngine> simulationEngineProvider;

  public DeliveryRepositoryImpl_Factory(Provider<FirebaseFirestore> firestoreProvider,
      Provider<SimulatedLocationEngine> simulationEngineProvider) {
    this.firestoreProvider = firestoreProvider;
    this.simulationEngineProvider = simulationEngineProvider;
  }

  @Override
  public DeliveryRepositoryImpl get() {
    return newInstance(firestoreProvider.get(), simulationEngineProvider.get());
  }

  public static DeliveryRepositoryImpl_Factory create(Provider<FirebaseFirestore> firestoreProvider,
      Provider<SimulatedLocationEngine> simulationEngineProvider) {
    return new DeliveryRepositoryImpl_Factory(firestoreProvider, simulationEngineProvider);
  }

  public static DeliveryRepositoryImpl newInstance(FirebaseFirestore firestore,
      SimulatedLocationEngine simulationEngine) {
    return new DeliveryRepositoryImpl(firestore, simulationEngine);
  }
}
