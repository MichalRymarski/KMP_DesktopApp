package ui.main

import androidx.compose.ui.window.WindowState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.dao.DesktopDao
import model.data.entity.Character
import model.data.entity.Episode
import network.KtorClient

class DesktopViewModel(
    private val windowState: WindowState,
    private val dao: DesktopDao,
) : ViewModel() {

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()
    var episodes = mutableListOf<Episode>()
        private set

    var currentCharacter: Character? = null
        private set

    init {
        getAllCharacters()
    }

    fun setCurrentCharacter(character: Character) {
        currentCharacter = character
        addEpisodesForCharacter(character.episode)
    }

    private fun getAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            dao.getAllCharacters().collect() { all ->
                _characters.update { all }
            }
        }
    }

    private fun addEpisodesForCharacter(urls: List<String>) {
        episodes.clear()
        viewModelScope.launch() {
            urls.forEach({ url ->
                episodes.add(KtorClient.getEpisodeByUrl(url,dao))
            })
        }
    }

    fun addCharacter(character: Character) {
        viewModelScope.launch {
            dao.insertCharacter(character)
        }
    }

    fun addEpisode(episode: Episode) {
        viewModelScope.launch {
            dao.insertEpisode(episode)
        }
    }

    fun getEpisodeByCharacterUrl(url: String) {
        viewModelScope.launch {
            episodes = dao.getEpisodesByCharacterUrl(url).toMutableList()
        }
    }

}