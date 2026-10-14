package com.quickbite.app;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.functions.FirebaseFunctions;
import com.quickbite.app.core.location.SimulatedLocationEngine;
import com.quickbite.app.data.repository.AuthRepositoryImpl;
import com.quickbite.app.data.repository.CartRepositoryImpl;
import com.quickbite.app.data.repository.DeliveryRepositoryImpl;
import com.quickbite.app.data.repository.OrderRepositoryImpl;
import com.quickbite.app.data.repository.RestaurantRepositoryImpl;
import com.quickbite.app.di.FirebaseModule_ProvideFirebaseAuthFactory;
import com.quickbite.app.di.FirebaseModule_ProvideFirebaseFirestoreFactory;
import com.quickbite.app.di.FirebaseModule_ProvideFirebaseFunctionsFactory;
import com.quickbite.app.di.FirebaseModule_ProvideSimulatedLocationEngineFactory;
import com.quickbite.app.feature.customer.cart.CartViewModel;
import com.quickbite.app.feature.customer.cart.CartViewModel_HiltModules;
import com.quickbite.app.feature.customer.checkout.CheckoutViewModel;
import com.quickbite.app.feature.customer.checkout.CheckoutViewModel_HiltModules;
import com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel;
import com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel_HiltModules;
import com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel;
import com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel_HiltModules;
import com.quickbite.app.feature.customer.history.OrderHistoryViewModel;
import com.quickbite.app.feature.customer.history.OrderHistoryViewModel_HiltModules;
import com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel;
import com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel_HiltModules;
import com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel;
import com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel_HiltModules;
import com.quickbite.app.feature.profile.ProfileViewModel;
import com.quickbite.app.feature.profile.ProfileViewModel_HiltModules;
import com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel;
import com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerQuickBiteApplication_HiltComponents_SingletonC {
  private DaggerQuickBiteApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static QuickBiteApplication_HiltComponents.SingletonC create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public QuickBiteApplication_HiltComponents.SingletonC build() {
      return new SingletonCImpl();
    }
  }

  private static final class ActivityRetainedCBuilder implements QuickBiteApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements QuickBiteApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements QuickBiteApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements QuickBiteApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements QuickBiteApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements QuickBiteApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements QuickBiteApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public QuickBiteApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends QuickBiteApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends QuickBiteApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends QuickBiteApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends QuickBiteApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(9).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_cart_CartViewModel, CartViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_checkout_CheckoutViewModel, CheckoutViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel, DeliveryDashboardViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_history_OrderHistoryViewModel, OrderHistoryViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel, OrderTrackingViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_profile_ProfileViewModel, ProfileViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel, RestaurantDashboardViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel, RestaurantDetailsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel, RestaurantDiscoveryViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel = "com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel";

      static String com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel = "com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel";

      static String com_quickbite_app_feature_customer_checkout_CheckoutViewModel = "com.quickbite.app.feature.customer.checkout.CheckoutViewModel";

      static String com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel = "com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel";

      static String com_quickbite_app_feature_profile_ProfileViewModel = "com.quickbite.app.feature.profile.ProfileViewModel";

      static String com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel = "com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel";

      static String com_quickbite_app_feature_customer_cart_CartViewModel = "com.quickbite.app.feature.customer.cart.CartViewModel";

      static String com_quickbite_app_feature_customer_history_OrderHistoryViewModel = "com.quickbite.app.feature.customer.history.OrderHistoryViewModel";

      static String com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel = "com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel";

      @KeepFieldType
      RestaurantDetailsViewModel com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel2;

      @KeepFieldType
      RestaurantDiscoveryViewModel com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel2;

      @KeepFieldType
      CheckoutViewModel com_quickbite_app_feature_customer_checkout_CheckoutViewModel2;

      @KeepFieldType
      DeliveryDashboardViewModel com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel2;

      @KeepFieldType
      ProfileViewModel com_quickbite_app_feature_profile_ProfileViewModel2;

      @KeepFieldType
      OrderTrackingViewModel com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel2;

      @KeepFieldType
      CartViewModel com_quickbite_app_feature_customer_cart_CartViewModel2;

      @KeepFieldType
      OrderHistoryViewModel com_quickbite_app_feature_customer_history_OrderHistoryViewModel2;

      @KeepFieldType
      RestaurantDashboardViewModel com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel2;
    }
  }

  private static final class ViewModelCImpl extends QuickBiteApplication_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<CartViewModel> cartViewModelProvider;

    private Provider<CheckoutViewModel> checkoutViewModelProvider;

    private Provider<DeliveryDashboardViewModel> deliveryDashboardViewModelProvider;

    private Provider<OrderHistoryViewModel> orderHistoryViewModelProvider;

    private Provider<OrderTrackingViewModel> orderTrackingViewModelProvider;

    private Provider<ProfileViewModel> profileViewModelProvider;

    private Provider<RestaurantDashboardViewModel> restaurantDashboardViewModelProvider;

    private Provider<RestaurantDetailsViewModel> restaurantDetailsViewModelProvider;

    private Provider<RestaurantDiscoveryViewModel> restaurantDiscoveryViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.cartViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.checkoutViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.deliveryDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.orderHistoryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.orderTrackingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.restaurantDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.restaurantDetailsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.restaurantDiscoveryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(9).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_cart_CartViewModel, ((Provider) cartViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_checkout_CheckoutViewModel, ((Provider) checkoutViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel, ((Provider) deliveryDashboardViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_history_OrderHistoryViewModel, ((Provider) orderHistoryViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel, ((Provider) orderTrackingViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_profile_ProfileViewModel, ((Provider) profileViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel, ((Provider) restaurantDashboardViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel, ((Provider) restaurantDetailsViewModelProvider)).put(LazyClassKeyProvider.com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel, ((Provider) restaurantDiscoveryViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel = "com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel";

      static String com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel = "com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel";

      static String com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel = "com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel";

      static String com_quickbite_app_feature_customer_checkout_CheckoutViewModel = "com.quickbite.app.feature.customer.checkout.CheckoutViewModel";

      static String com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel = "com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel";

      static String com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel = "com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel";

      static String com_quickbite_app_feature_customer_history_OrderHistoryViewModel = "com.quickbite.app.feature.customer.history.OrderHistoryViewModel";

      static String com_quickbite_app_feature_profile_ProfileViewModel = "com.quickbite.app.feature.profile.ProfileViewModel";

      static String com_quickbite_app_feature_customer_cart_CartViewModel = "com.quickbite.app.feature.customer.cart.CartViewModel";

      @KeepFieldType
      OrderTrackingViewModel com_quickbite_app_feature_customer_tracking_OrderTrackingViewModel2;

      @KeepFieldType
      RestaurantDetailsViewModel com_quickbite_app_feature_customer_details_RestaurantDetailsViewModel2;

      @KeepFieldType
      RestaurantDiscoveryViewModel com_quickbite_app_feature_customer_discovery_RestaurantDiscoveryViewModel2;

      @KeepFieldType
      CheckoutViewModel com_quickbite_app_feature_customer_checkout_CheckoutViewModel2;

      @KeepFieldType
      DeliveryDashboardViewModel com_quickbite_app_feature_delivery_dashboard_DeliveryDashboardViewModel2;

      @KeepFieldType
      RestaurantDashboardViewModel com_quickbite_app_feature_restaurant_dashboard_RestaurantDashboardViewModel2;

      @KeepFieldType
      OrderHistoryViewModel com_quickbite_app_feature_customer_history_OrderHistoryViewModel2;

      @KeepFieldType
      ProfileViewModel com_quickbite_app_feature_profile_ProfileViewModel2;

      @KeepFieldType
      CartViewModel com_quickbite_app_feature_customer_cart_CartViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.quickbite.app.feature.customer.cart.CartViewModel 
          return (T) new CartViewModel(singletonCImpl.cartRepositoryImplProvider.get());

          case 1: // com.quickbite.app.feature.customer.checkout.CheckoutViewModel 
          return (T) new CheckoutViewModel(singletonCImpl.cartRepositoryImplProvider.get(), singletonCImpl.orderRepositoryImplProvider.get(), singletonCImpl.authRepositoryImplProvider.get());

          case 2: // com.quickbite.app.feature.delivery.dashboard.DeliveryDashboardViewModel 
          return (T) new DeliveryDashboardViewModel(singletonCImpl.orderRepositoryImplProvider.get(), singletonCImpl.deliveryRepositoryImplProvider.get(), singletonCImpl.authRepositoryImplProvider.get());

          case 3: // com.quickbite.app.feature.customer.history.OrderHistoryViewModel 
          return (T) new OrderHistoryViewModel(singletonCImpl.orderRepositoryImplProvider.get(), singletonCImpl.authRepositoryImplProvider.get());

          case 4: // com.quickbite.app.feature.customer.tracking.OrderTrackingViewModel 
          return (T) new OrderTrackingViewModel(viewModelCImpl.savedStateHandle, singletonCImpl.orderRepositoryImplProvider.get(), singletonCImpl.deliveryRepositoryImplProvider.get());

          case 5: // com.quickbite.app.feature.profile.ProfileViewModel 
          return (T) new ProfileViewModel(singletonCImpl.authRepositoryImplProvider.get(), singletonCImpl.restaurantRepositoryImplProvider.get());

          case 6: // com.quickbite.app.feature.restaurant.dashboard.RestaurantDashboardViewModel 
          return (T) new RestaurantDashboardViewModel(singletonCImpl.orderRepositoryImplProvider.get(), singletonCImpl.authRepositoryImplProvider.get());

          case 7: // com.quickbite.app.feature.customer.details.RestaurantDetailsViewModel 
          return (T) new RestaurantDetailsViewModel(viewModelCImpl.savedStateHandle, singletonCImpl.restaurantRepositoryImplProvider.get(), singletonCImpl.cartRepositoryImplProvider.get());

          case 8: // com.quickbite.app.feature.customer.discovery.RestaurantDiscoveryViewModel 
          return (T) new RestaurantDiscoveryViewModel(singletonCImpl.restaurantRepositoryImplProvider.get(), singletonCImpl.cartRepositoryImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends QuickBiteApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends QuickBiteApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends QuickBiteApplication_HiltComponents.SingletonC {
    private final SingletonCImpl singletonCImpl = this;

    private Provider<CartRepositoryImpl> cartRepositoryImplProvider;

    private Provider<FirebaseFirestore> provideFirebaseFirestoreProvider;

    private Provider<FirebaseFunctions> provideFirebaseFunctionsProvider;

    private Provider<OrderRepositoryImpl> orderRepositoryImplProvider;

    private Provider<FirebaseAuth> provideFirebaseAuthProvider;

    private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

    private Provider<SimulatedLocationEngine> provideSimulatedLocationEngineProvider;

    private Provider<DeliveryRepositoryImpl> deliveryRepositoryImplProvider;

    private Provider<RestaurantRepositoryImpl> restaurantRepositoryImplProvider;

    private SingletonCImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.cartRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<CartRepositoryImpl>(singletonCImpl, 0));
      this.provideFirebaseFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 2));
      this.provideFirebaseFunctionsProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFunctions>(singletonCImpl, 3));
      this.orderRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<OrderRepositoryImpl>(singletonCImpl, 1));
      this.provideFirebaseAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 5));
      this.authRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepositoryImpl>(singletonCImpl, 4));
      this.provideSimulatedLocationEngineProvider = DoubleCheck.provider(new SwitchingProvider<SimulatedLocationEngine>(singletonCImpl, 7));
      this.deliveryRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<DeliveryRepositoryImpl>(singletonCImpl, 6));
      this.restaurantRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<RestaurantRepositoryImpl>(singletonCImpl, 8));
    }

    @Override
    public void injectQuickBiteApplication(QuickBiteApplication arg0) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.quickbite.app.data.repository.CartRepositoryImpl 
          return (T) new CartRepositoryImpl();

          case 1: // com.quickbite.app.data.repository.OrderRepositoryImpl 
          return (T) new OrderRepositoryImpl(singletonCImpl.provideFirebaseFirestoreProvider.get(), singletonCImpl.provideFirebaseFunctionsProvider.get());

          case 2: // com.google.firebase.firestore.FirebaseFirestore 
          return (T) FirebaseModule_ProvideFirebaseFirestoreFactory.provideFirebaseFirestore();

          case 3: // com.google.firebase.functions.FirebaseFunctions 
          return (T) FirebaseModule_ProvideFirebaseFunctionsFactory.provideFirebaseFunctions();

          case 4: // com.quickbite.app.data.repository.AuthRepositoryImpl 
          return (T) new AuthRepositoryImpl(singletonCImpl.provideFirebaseAuthProvider.get());

          case 5: // com.google.firebase.auth.FirebaseAuth 
          return (T) FirebaseModule_ProvideFirebaseAuthFactory.provideFirebaseAuth();

          case 6: // com.quickbite.app.data.repository.DeliveryRepositoryImpl 
          return (T) new DeliveryRepositoryImpl(singletonCImpl.provideFirebaseFirestoreProvider.get(), singletonCImpl.provideSimulatedLocationEngineProvider.get());

          case 7: // com.quickbite.app.core.location.SimulatedLocationEngine 
          return (T) FirebaseModule_ProvideSimulatedLocationEngineFactory.provideSimulatedLocationEngine();

          case 8: // com.quickbite.app.data.repository.RestaurantRepositoryImpl 
          return (T) new RestaurantRepositoryImpl(singletonCImpl.provideFirebaseFirestoreProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
