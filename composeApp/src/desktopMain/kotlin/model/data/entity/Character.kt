package model.data.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
@Entity(
    tableName = "characters",

    )
data class Character(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "character_url")
    val url : String,
    @ColumnInfo(name = "character_id")
    val id: Int,
    @ColumnInfo(name = "character_name")
    val name: String,
    @ColumnInfo(name = "character_status")
    val status: String,
    @ColumnInfo(name = "character_species")
    val species: String,
    @ColumnInfo(name = "character_gender")
    val gender: String,
    @Embedded(prefix = "origin_") // Add prefix for Origin
    val origin: Origin,
    @Embedded(prefix = "location_") // Add prefix for Location
    val location: Location,
    @ColumnInfo(name = "image_url")
    val image: String,
    @ColumnInfo(name = "episodes")
    val episode: List<String>


)

