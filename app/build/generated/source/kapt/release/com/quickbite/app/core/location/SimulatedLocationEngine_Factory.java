package com.quickbite.app.core.location;

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
public final class SimulatedLocationEngine_Factory implements Factory<SimulatedLocationEngine> {
  @Override
  public SimulatedLocationEngine get() {
    return newInstance();
  }

  public static SimulatedLocationEngine_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SimulatedLocationEngine newInstance() {
    return new SimulatedLocationEngine();
  }

  private static final class InstanceHolder {
    private static final SimulatedLocationEngine_Factory INSTANCE = new SimulatedLocationEngine_Factory();
  }
}
