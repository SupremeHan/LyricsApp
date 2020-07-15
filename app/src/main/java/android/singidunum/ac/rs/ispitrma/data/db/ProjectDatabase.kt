package android.singidunum.ac.rs.ispitrma.data.db

import android.singidunum.ac.rs.ispitrma.data.datasources.local.TracksDao
import android.singidunum.ac.rs.ispitrma.data.entities.TracksEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TracksEntity::class],
    version = 2,
    exportSchema = false)
abstract class ProjectDatabase : RoomDatabase() {
    abstract fun getTracksDao(): TracksDao
}