package android.singidunum.ac.rs.ispitrma.presentation.contract

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import androidx.lifecycle.LiveData

interface FavouritesContract {
    interface ViewModel {

        val favourites: LiveData<List<Tracks>>

        fun getAll()
        fun delete(id: Long)
        fun insert(tracks: Tracks)
    }
}