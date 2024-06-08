package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.resources.MyTheme

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier,
    desktopViewModel: DesktopViewModel,
    navController: NavHostController,
) {
    val url = "https://perla.pl/wp-content/uploads/2023/08/Perla_chmielowa_05_474x1024px.png"
    Row(
        modifier = modifier.background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
        CoilImage(
            modifier = Modifier.weight(1f),
            imageModel = {  url  }, // loading a network image or local resource using an URL.
            imageOptions = ImageOptions(
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )
        )
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