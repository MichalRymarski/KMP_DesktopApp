package model.data.converters

import androidx.room.TypeConverter
import model.data.entity.Location

class LocationConverter {
    @TypeConverter
    fun fromLocation(origin : Location?) : String?{
        return origin?.let { "${it.name} ${it.url}" }
    }
    @TypeConverter
    fun toLocation(value : String?) : Location?{
        return value?.split(" ")?.let {
            if (it.size == 2) Location(it[0], it[1]) else null
        }
    }
}