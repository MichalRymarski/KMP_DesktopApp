package ui.resources

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme())
            darkColors(
                background = Color.DarkGray,
                primary = Color(0xFFBB86FC), // Purple
                primaryVariant = Color(0xFF3700B3), // Darker purple
                secondary = Color(0xFF03DAC5) // Teal
    )
    else lightColors(
            background = Color.DarkGray,
            primary = Color(0xFF6200EE), // Another shade of purple
            primaryVariant = Color(0xFF3700B3), // Same darker purple
            secondary = Color(0xFF018786) // Slightly
    ),
    typography = MaterialTheme.typography,
    shapes = Shapes()
    ) {
        content()
    }
}