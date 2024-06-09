package model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import model.data.Character

@Dao
interface DesktopDao {
   /* @Insert
    suspend fun insertCharacter(character : Character)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters() : List<Character>*/
}