package com.quickbite.app.di;

import com.quickbite.app.core.location.SimulatedLocationEngine;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class FirebaseModule_ProvideSimulatedLocationEngineFactory implements Factory<SimulatedLocationEngine> {
  @Override
  public SimulatedLocationEngine get() {
    return provideSimulatedLocationEngine();
  }

  public static FirebaseModule_ProvideSimulatedLocationEngineFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SimulatedLocationEngine provideSimulatedLocationEngine() {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideSimulatedLocationEngine());
  }

  private static final class InstanceHolder {
    private static final FirebaseModule_ProvideSimulatedLocationEngineFactory INSTANCE = new FirebaseModule_ProvideSimulatedLocationEngineFactory();
  }
}
