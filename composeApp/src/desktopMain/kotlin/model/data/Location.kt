package model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
@Entity(tableName = "locations")
data class Location(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "location_name")
    val name: String,
    @ColumnInfo(name = "location_url")
    val url: String? = null
)
