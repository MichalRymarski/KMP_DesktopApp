package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage

@Composable
fun LeftScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val url = "https://perla.pl/wp-content/uploads/2023/08/Perla_miodowa_05_474x1024px.png"


    Row (
        modifier = modifier.background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.End
    ){
        CoilImage(
            modifier = Modifier.weight(1f),
            imageModel = { url }, // loading a network image or local resource using an URL.
            imageOptions = ImageOptions(
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center
            )
        )
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate("main")
            }) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}