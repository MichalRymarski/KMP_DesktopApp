package model.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import model.data.entity.Character
import model.data.entity.Episode

data class CharacterWithEpisodes(
    @Embedded val character : Character,
    @Relation(
        parentColumn = "character_url",
        entityColumn = "url",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val episodes : List<Episode>
)
