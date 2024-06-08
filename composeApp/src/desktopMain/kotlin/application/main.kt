package application

import ui.App
import ui.DesktopViewModel
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.navigation.compose.rememberNavController
import ui.DesktopNavigation
import ui.resources.MyTheme

fun main() = application {
    val navController = rememberNavController()

    val windowState = rememberWindowState(
        placement =  WindowPlacement.Maximized
    )
    val desktopViewModel = remember { DesktopViewModel(windowState) }

    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "Bazingus",
    ) {
        MyTheme {
            DesktopNavigation(navController,desktopViewModel)
        }
    }
}
