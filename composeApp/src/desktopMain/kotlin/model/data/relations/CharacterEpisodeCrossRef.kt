package model.data.relations

import androidx.room.Entity

@Entity(primaryKeys = ["character_url","url"])
data class CharacterEpisodeCrossRef(
    val id : Int,
    val url : String
)
