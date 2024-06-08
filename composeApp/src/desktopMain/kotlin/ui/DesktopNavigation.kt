package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun DesktopNavigation(
    navController : NavHostController,
    desktopViewModel: DesktopViewModel
    ) {
    val modifier = Modifier.fillMaxSize()

    NavHost(
        navController = navController,
        startDestination = "main"
    ){
        composable(route = "main"){
            App(modifier,desktopViewModel,navController)
        }
        composable(route ="left"){
            LeftScreen(modifier,navController)
        }
        composable(route= "right"){
            RightScreen(modifier,navController)
        }
    }

}

