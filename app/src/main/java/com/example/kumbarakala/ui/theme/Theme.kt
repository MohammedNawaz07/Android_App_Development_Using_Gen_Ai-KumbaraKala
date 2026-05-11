package com.example.kumbarakala.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ClayDark = Color(0xFF3E2723)
val ClayOrange = Color(0xFFD84315)
val ClayCream = Color(0xFFFFFBF7)
val ClayPrimary = Color(0xFF5D4037)

private val LightColorScheme = lightColorScheme(
    primary = ClayPrimary,
    secondary = ClayOrange,
    tertiary = ClayDark,
    background = ClayCream,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = ClayDark,
    onSurface = ClayDark,
)

@Composable
fun KumbaraKalaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        // We stick to light-ish theme as per original design's vibe
        LightColorScheme 
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
