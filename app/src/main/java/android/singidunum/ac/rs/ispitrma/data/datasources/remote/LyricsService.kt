package android.singidunum.ac.rs.ispitrma.data.datasources.remote

import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns
import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LyricsService {
    @GET("track.lyrics.get?track_id=15953433")
    fun getLyrics(@Query(Constatns.API_KEY) apiKey: String,
                  @Query(Constatns.TRACK_ID) trackId: Int
    ): Observable<LyricsResponse>
}