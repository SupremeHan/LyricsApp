package android.singidunum.ac.rs.ispitrma.data.repository

import android.singidunum.ac.rs.ispitrma.data.datasources.local.TracksDao
import android.singidunum.ac.rs.ispitrma.data.entities.TracksEntity
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import io.reactivex.Completable
import io.reactivex.Observable

class FavouritesRepositoryImpl(private val tracksDao: TracksDao) : FavouritesRepository {

    override fun getAll(): Observable<List<Tracks>> {
        return tracksDao
            .getAll()
            .map {
                it.map { tracks ->
                    Tracks(tracks.trackId, tracks.trackName, tracks.trackAlbumName)
                }
            }
    }

    override fun insert(tracks: Tracks): Completable {
        val tracksEntity = TracksEntity(0, tracks.trackId, tracks.trackName, tracks.albumName)
        return tracksDao.insert(tracksEntity)
    }

    override fun delete(idTracks: Long): Completable {
        return tracksDao.delete(idTracks)
    }

}