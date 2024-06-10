package model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "episodes")
data class Episode(
    @PrimaryKey
    @NotNull
    val id: Int,
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "air_date")
    val airDate : String,
    @ColumnInfo(name = "episode")
    val episode : String,
    @ColumnInfo("characters")
    val characters : List<String>
)

