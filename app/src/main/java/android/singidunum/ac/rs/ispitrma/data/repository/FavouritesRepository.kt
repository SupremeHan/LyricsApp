package android.singidunum.ac.rs.ispitrma.data.repository

import android.singidunum.ac.rs.ispitrma.data.entities.TracksEntity
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import io.reactivex.Completable
import io.reactivex.Observable

interface FavouritesRepository {
    fun getAll(): Observable<List<Tracks>>

    fun insert(tracks: Tracks): Completable

    fun delete(idTracks: Long): Completable
}