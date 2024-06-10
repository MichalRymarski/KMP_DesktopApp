package ui.character_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import ui.DesktopViewModel

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    desktopViewModel: DesktopViewModel,
    navController: NavHostController
) {

    val character = desktopViewModel.currentCharacter!!
    val fontSize = 22.sp
    val textVerticalSpacing = Modifier.padding(top= 10.dp, bottom = 10.dp)

    Column(
        modifier = modifier
    ) {
        TopAppBar(
            title = { Text(character.name, fontSize = 26.sp) },
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                NavigationButton(
                    { navController.popBackStack() },
                    Icons.AutoMirrored.Default.KeyboardArrowLeft
                )
            }
        )
        Row(
            modifier = modifier.background(MaterialTheme.colors.background).padding(15.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                CoilImage(
                    modifier = Modifier.clip(RoundedCornerShape(20.dp)),
                    imageModel = { character.image },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.FillBounds,
                    )
                )

                Text("Name: ${character.name}",modifier = textVerticalSpacing, fontSize = fontSize)
                Text("Gender: ${character.gender}",modifier = textVerticalSpacing, fontSize= fontSize)
                Text("Specie: ${character.species}",modifier = textVerticalSpacing, fontSize= fontSize)
                Text("Origin: ${character.origin.name}",modifier = textVerticalSpacing, fontSize= fontSize)
                Text("Location: ${character.location.name}",modifier = textVerticalSpacing, fontSize= fontSize)
                Text("Status: ${character.status}",modifier = textVerticalSpacing, fontSize= fontSize)

            }

            Column(modifier = Modifier.weight(3.5f)) {
                Text("EPISODES:", fontSize = 32.sp, modifier = Modifier.align(Alignment.Start), fontWeight = FontWeight.SemiBold)
            }
        }
    }
}