package model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import model.data.Character

@Dao
interface DesktopDao {
    @Insert
    suspend fun insertCharacter(character : Character)

    @Query("SELECT * FROM characters")
    fun getAllCharacters() : Flow<List<Character>>
}