package com.product.mostusedpassword.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MostUsedPasswordTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Material Colors
    val colors = if (darkTheme) {
        darkColors(
            primary = Purple200,
            primaryVariant = Purple700,
            secondary = Teal200
        )
    } else {
        lightColors(
            primary = Purple500,
            primaryVariant = Purple700,
            secondary = Teal200

            /* Other default colors to override
            background = Color.White,
            surface = Color.White,
            onPrimary = Color.White,
            onSecondary = Color.Black,
            onBackground = Color.Black,
            onSurface = Color.Black,
            */
        )
    }

    // Material Typography
    val typography = Typography()

    // Material Shapes
    val shapes = Shapes()

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

// Define your color palette
private val Purple200 = Color(0xFFBB86FC)
private val Purple500 = Color(0xFF6200EE)
private val Purple700 = Color(0xFF3700B3)
private val Teal200 = Color(0xFF03DAC5)
