package model.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Serializable
@Entity(tableName = "origins")
data class Origin(
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "origin_name")
    val name: String,
    @ColumnInfo(name = "origin_url")
    val url: String? = null
)
