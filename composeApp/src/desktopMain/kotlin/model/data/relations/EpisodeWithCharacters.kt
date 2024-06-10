package model.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import model.data.entity.Character
import model.data.entity.Episode

data class EpisodeWithCharacters(
    @Embedded
    val episode: Episode,
    @Relation(
        parentColumn = "url",
        entityColumn = "character_url",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val characters: List<Character>
)
