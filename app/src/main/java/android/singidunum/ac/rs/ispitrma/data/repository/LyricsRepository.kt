package android.singidunum.ac.rs.ispitrma.data.repository

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import io.reactivex.Observable

interface LyricsRepository {

    fun getLyrics(trackId: Int): Observable<LyricsResponse>
}