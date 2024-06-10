package model.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import model.dao.DesktopDao
import model.data.entity.Character
import model.data.converters.LocationConverter
import model.data.converters.OriginConverter
import model.data.converters.StringListConverter
import model.data.entity.Episode
import java.io.File

@Database(
    version =5,
    entities = [Character::class, Episode::class],
    exportSchema = true
    )
@TypeConverters(OriginConverter::class, LocationConverter::class,StringListConverter::class)
abstract class DesktopDatabase : RoomDatabase() {
    abstract fun dao(): DesktopDao

    companion object {
        @Volatile
        private var instance: DesktopDatabase? = null
        private fun getDatabaseBuilder(): RoomDatabase.Builder<DesktopDatabase> {
            val userDir = System.getProperty("user.dir")
            val dbFile = File(userDir, "DesktopFun/db/desktop_database.db")
            print("DB: ${dbFile.absolutePath}")

            return Room.databaseBuilder<DesktopDatabase>(
                name = dbFile.absolutePath,
            )
        }

        fun getDatabase(): DesktopDatabase {
            return instance ?: getDatabaseBuilder().setDriver(BundledSQLiteDriver()).fallbackToDestructiveMigration(dropAllTables = true).build()
            }
        }

    }
