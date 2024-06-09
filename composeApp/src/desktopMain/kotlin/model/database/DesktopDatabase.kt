package model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import model.dao.DesktopDao
import model.data.Location
import model.data.Origin

@Database(
    version =1,
    entities = [Character::class, Origin::class, Location::class],
)
abstract class DesktopDatabase : RoomDatabase() {
    abstract fun dao(): DesktopDao
}