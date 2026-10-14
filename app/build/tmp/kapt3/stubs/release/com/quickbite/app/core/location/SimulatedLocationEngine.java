package com.quickbite.app.core.location;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0010\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u0005J\u0010\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0005J.\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020#2\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001f\u0018\u00010%J\u0006\u0010&\u001a\u00020\u001fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/quickbite/app/core/location/SimulatedLocationEngine;", "", "()V", "_currentStep", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isSimulating", "", "currentStep", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStep", "()Lkotlinx/coroutines/flow/StateFlow;", "isSimulating", "routeWaypoints", "", "Lcom/quickbite/app/core/location/Coordinates;", "getRouteWaypoints", "()Ljava/util/List;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "simulationJob", "Lkotlinx/coroutines/Job;", "advanceStep", "calculateBearing", "", "from", "to", "getCurrentCoordinate", "step", "getProgressPercent", "reset", "", "setStep", "startSimulation", "intervalMs", "", "onStep", "Lkotlin/Function2;", "stopSimulation", "app_release"})
public final class SimulatedLocationEngine {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.quickbite.app.core.location.Coordinates> routeWaypoints = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSimulating = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSimulating = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job simulationJob;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    @javax.inject.Inject()
    public SimulatedLocationEngine() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.quickbite.app.core.location.Coordinates> getRouteWaypoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCurrentStep() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSimulating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.quickbite.app.core.location.Coordinates getCurrentCoordinate(int step) {
        return null;
    }
    
    public final int getProgressPercent(int step) {
        return 0;
    }
    
    public final float calculateBearing(@org.jetbrains.annotations.NotNull()
    com.quickbite.app.core.location.Coordinates from, @org.jetbrains.annotations.NotNull()
    com.quickbite.app.core.location.Coordinates to) {
        return 0.0F;
    }
    
    /**
     * Advances simulation by one deterministic step.
     * Perfect for instant demonstration in client meetings.
     */
    public final int advanceStep() {
        return 0;
    }
    
    public final void setStep(int step) {
    }
    
    public final void reset() {
    }
    
    /**
     * Starts continuous auto-advance simulation every [intervalMs].
     */
    public final void startSimulation(long intervalMs, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.quickbite.app.core.location.Coordinates, kotlin.Unit> onStep) {
    }
    
    public final void stopSimulation() {
    }
}