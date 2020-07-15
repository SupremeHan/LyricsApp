package android.singidunum.ac.rs.ispitrma.data.repository


import android.singidunum.ac.rs.ispitrma.data.models.api.entities.Track
import android.singidunum.ac.rs.ispitrma.data.models.api.entities.TrackChartResponse
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import io.reactivex.Observable
import retrofit2.http.GET

interface TrackChartRepository {

    @GET("chart_name=top&page=1&page_size=5&country=it&f_has_lyrics=1")
    fun getAll(): Observable<List<Tracks>>
}