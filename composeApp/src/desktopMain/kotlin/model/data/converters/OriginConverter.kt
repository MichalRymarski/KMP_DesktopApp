package model.data.converters

import androidx.room.TypeConverter
import model.data.entity.Origin


class OriginConverter{
    @TypeConverter
    fun fromOrigin(origin : Origin?) : String?{
        return origin?.let { "${it.name} ${it.url}" }
    }
    @TypeConverter
    fun toOrigin(value : String?) : Origin?{
        return value?.split(" ")?.let {
            if (it.size == 2) Origin(it[0], it[1]) else null
        }
    }

}