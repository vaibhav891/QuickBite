package com.quickbite.app.core.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = CoralPrimaryDark,
    onPrimary = SurfaceDark,
    primaryContainer = CoralDark,
    onPrimaryContainer = TextPrimaryDark,
    secondary = AmberSecondaryDark,
    onSecondary = SurfaceDark,
    background = BackgroundDark,
    onBackground = TextPrimaryDark,
    surface = SurfaceDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = TextSecondaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = CoralPrimary,
    onPrimary = SurfaceLight,
    primaryContainer = CoralPrimary.copy(alpha = 0.12f),
    onPrimaryContainer = CoralDark,
    secondary = AmberSecondary,
    onSecondary = SurfaceLight,
    background = BackgroundLight,
    onBackground = TextPrimaryLight,
    surface = SurfaceLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = TextSecondaryLight
)

@Composable
fun QuickBiteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = QuickBiteTypography,
        shapes = QuickBiteShapes,
        content = content
    )
}
