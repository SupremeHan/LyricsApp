package android.singidunum.ac.rs.ispitrma.data.datasources.local

import android.singidunum.ac.rs.ispitrma.data.entities.TracksEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
abstract class TracksDao {

    @Query("SELECT * FROM tracks")
    abstract fun getAll(): Observable<List<TracksEntity>>

    @Insert
    abstract fun insert(entity: TracksEntity): Completable

    @Query("DELETE FROM tracks WHERE trackId = :idTracks")
    abstract fun delete(idTracks: Long): Completable

}