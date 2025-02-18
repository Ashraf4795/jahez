package com.jahez.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = neutral_900,
    onPrimary = neutral_50,
    secondary = primary_500,
    tertiary = primary_200,
    onSecondary = Color.White,
    surface = neutral_700,
    onSurface = neutral_100,
    outline = neutral_100,
    outlineVariant = neutral_700,
    onError = primary_500
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = neutral_900,
    secondary = primary_500,
    tertiary = primary_200,
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = neutral_900,
    outline = Color.White,
    outlineVariant = neutral_50,
    onError = primary_500,
)

@Composable
fun JahezTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}