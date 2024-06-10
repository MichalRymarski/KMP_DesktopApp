package model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import model.data.entity.Character
import model.data.entity.Episode

@Dao
interface DesktopDao {
    @Insert
    suspend fun insertCharacter(character : Character)
    @Insert
    suspend fun insertEpisode(episode: Episode)
    @Query("SELECT * FROM characters")
    fun getAllCharacters() : Flow<List<Character>>

    @Transaction
    @Query("SELECT * FROM episodes WHERE characters LIKE '%' || :url || '%'")
    suspend fun getEpisodesByCharacterUrl(url: String) : List<Episode>

    @Query("SELECT * FROM episodes WHERE url = :url")
    suspend fun getEpisodeByUrl(url: String): Episode?
}