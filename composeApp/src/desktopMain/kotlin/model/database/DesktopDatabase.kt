package model.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.sun.tools.javac.util.Context
import kotlinx.coroutines.internal.synchronized
import model.dao.DesktopDao
import model.data.Character
import model.data.Location
import model.data.LocationConverter
import model.data.Origin
import model.data.OriginConverter
import java.io.File

@Database(
    version =1,
    entities = [Character::class],
    )
@TypeConverters(OriginConverter::class, LocationConverter::class)
abstract class DesktopDatabase : RoomDatabase() {
    abstract fun dao(): DesktopDao

    companion object {
        @Volatile
        private var instance: DesktopDatabase? = null
        private fun getDatabaseBuilder(): RoomDatabase.Builder<DesktopDatabase> {
            val dbFile = File(System.getProperty("java.io.tmpdir"), "desktop_database.db")
            return Room.databaseBuilder<DesktopDatabase>(
                name = dbFile.absolutePath,
            )
        }

        fun getDatabase(): DesktopDatabase {
            return instance ?: getDatabaseBuilder().setDriver(BundledSQLiteDriver()).build()
            }
        }

    }
