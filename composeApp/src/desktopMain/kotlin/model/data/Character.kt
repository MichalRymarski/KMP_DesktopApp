package model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    @NotNull
    val id: Int,
    @ColumnInfo(name = "character_name")
    val name: String,
    @ColumnInfo(name = "character_status")
    val status: String,
    @ColumnInfo(name = "character_species")
    val species: String,
    @ColumnInfo(name = "character_gender")
    val gender: String,
    @ColumnInfo(name = "character_origin")
    val origin: Origin,
    @ColumnInfo(name = "character_location")
    val location: Location,
    @ColumnInfo(name = "image_url")
    val image: String

)

