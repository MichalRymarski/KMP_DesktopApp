package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.jetbrains.compose.ui.tooling.preview.Preview
import java.awt.SystemColor.text

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier,
    desktopViewModel: DesktopViewModel,
    navController: NavHostController,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "bazgag")
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("left")
            }) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                contentDescription = null
            )
        }
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("right")
            }) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }

    }
}