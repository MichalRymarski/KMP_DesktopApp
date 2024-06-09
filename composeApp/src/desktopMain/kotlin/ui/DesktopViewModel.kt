package ui

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.lifecycle.ViewModel
import model.dao.DesktopDao

class DesktopViewModel(
    private val windowState: WindowState,
    dao: DesktopDao,
) : ViewModel() {

     fun setFullscreen(){
          windowState.placement = WindowPlacement.Fullscreen
     }

     fun setMaximized(){
          windowState.placement = WindowPlacement.Maximized
     }

     fun setFloating(){
          windowState.placement = WindowPlacement.Floating
          windowState.size = DpSize(width = 1200.dp, height = 600.dp)
     }
}