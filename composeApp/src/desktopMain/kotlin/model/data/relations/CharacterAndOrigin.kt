package model.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import model.data.Character
import model.data.Origin

/*
data class CharacterAndOrigin(
    @Embedded
    val character : Character,
    @Relation(
        parentColumn = "character_origin",
        entityColumn = "origin_name"
    )
    val origin : Origin
)
*/
