package model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
data class Location(
    val name: String,
    val url: String
)
