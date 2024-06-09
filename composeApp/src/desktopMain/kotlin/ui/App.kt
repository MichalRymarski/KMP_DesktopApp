package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.isTypedEvent
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isAltPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import model.data.Character
import network.KtorClient
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.resources.MyTheme
import java.awt.event.KeyEvent

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier,
    desktopViewModel: DesktopViewModel,
    navController: NavHostController,
) {
    var character by remember { mutableStateOf<Character?>(null) }
    LaunchedEffect(key1 = null) {
        character = KtorClient.test()
    }

    var url = ""
    character?.let {
         url = it.image
    }
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
            imageModel = { url }, // loading a network image or local resource using an URL.
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