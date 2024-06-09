package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    modifier: Modifier = Modifier,
    desktopViewModel: DesktopViewModel,
    navController: NavHostController,
) {

    val characters = desktopViewModel.characters.collectAsState().value
    characters.forEach({
        println(it.name)
    })

    val state = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        modifier = modifier.background(MaterialTheme.colors.background),
        state = state,
        columns = StaggeredGridCells.FixedSize(300.dp),
        userScrollEnabled = true,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalItemSpacing = 20.dp
    ) {
        items(characters) { character ->
            CoilImage(
                modifier = Modifier.clip(RoundedCornerShape(20.dp)).clickable { /*TODO*/ },
                imageModel = { character.image }, // loading a network image or local resource using an URL.
                imageOptions = ImageOptions(
                    contentScale = ContentScale.FillBounds,
                )
            )
        }
    }

}