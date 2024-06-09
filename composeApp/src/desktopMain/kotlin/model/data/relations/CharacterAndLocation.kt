package model.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import model.data.Character
import model.data.Location

data class CharacterAndLocation(
    @Embedded
    val character : Character,
    @Relation(
        parentColumn = "character_location",
        entityColumn = "location_name"
    )
    val location : Location
)
