package android.singidunum.ac.rs.ispitrma.presentation.contract

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import androidx.lifecycle.LiveData

interface LyricsContract {
    interface ViewModel {

        val lyrics: LiveData<LyricsResponse>

        fun getLyrics(trackId: Int)
    }
}