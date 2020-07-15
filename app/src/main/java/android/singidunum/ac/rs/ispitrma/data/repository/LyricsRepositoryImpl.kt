package android.singidunum.ac.rs.ispitrma.data.repository

import android.singidunum.ac.rs.ispitrma.data.datasources.remote.LyricsService
import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import io.reactivex.Observable

class LyricsRepositoryImpl (private val lyricsService: LyricsService): LyricsRepository{

    override fun getLyrics(trackId: Int): Observable<LyricsResponse> {
        return lyricsService
            .getLyrics("d0a2522f1d273c54dc8151cdf8d3644a",trackId)
    }

}