package android.singidunum.ac.rs.ispitrma.data.datasources.remote

import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns.API_KEY
import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns.COUNTRY
import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns.TOP_PAGE
import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns.TOP_PAGE_SIZE
import android.singidunum.ac.rs.ispitrma.data.models.api.config.Constatns.TRACK_ID
import android.singidunum.ac.rs.ispitrma.data.models.api.entities.TrackChartResponse
import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import io.reactivex.Observable
import retrofit2.http.GET

import retrofit2.http.Query

interface TrackChartDataSource {
    @GET("chart.tracks.get?page=1&page_size=3&country=it")
    fun getAll(@Query(API_KEY) apiKey: String,
               @Query(COUNTRY) country: String?,
               @Query(TOP_PAGE) page: String,
               @Query(TOP_PAGE_SIZE) pageSize: String): Observable<TrackChartResponse>


}