package ui

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.dao.DesktopDao
import model.data.Character

class DesktopViewModel(
    private val windowState: WindowState,
    private val dao: DesktopDao,
) : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()

    init {
        getAllCharacters()
    }

    fun setFullscreen() {
        windowState.placement = WindowPlacement.Fullscreen
    }

    fun setMaximized() {
        windowState.placement = WindowPlacement.Maximized
    }

    fun getAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.getAllCharacters().collect() { all ->
                _characters.update { all }
            }
        }
    }

    fun addCharacter(character: Character) {
        viewModelScope.launch {
            dao.insertCharacter(character)
        }
    }

    fun setFloating() {
        windowState.placement = WindowPlacement.Floating
        windowState.size = DpSize(width = 1200.dp, height = 600.dp)
    }
}