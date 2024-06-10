package ui.character_screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun NavigationButton(onClick: () -> Unit, icon: ImageVector) {
    IconButton(
        onClick = onClick,
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.primary
        )
    }
}