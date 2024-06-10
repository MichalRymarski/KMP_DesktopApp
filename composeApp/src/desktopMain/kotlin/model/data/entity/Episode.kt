package model.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
@Entity(tableName = "episodes")
data class Episode(
    @ColumnInfo(name = "episode_id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "air_date")
    val air_date : String,
    @ColumnInfo(name = "episode")
    val episode : String,
    @ColumnInfo("characters")
    val characters : List<String>,
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "url")
    val url : String,

)

