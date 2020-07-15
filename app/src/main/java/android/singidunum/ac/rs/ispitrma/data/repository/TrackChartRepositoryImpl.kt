package android.singidunum.ac.rs.ispitrma.data.repository

import android.singidunum.ac.rs.ispitrma.data.datasources.remote.TrackChartDataSource
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import io.reactivex.Observable

class TrackChartRepositoryImpl (private val trackChartDataSource: TrackChartDataSource): TrackChartRepository {

    override fun getAll(): Observable<List<Tracks>> {
        return trackChartDataSource
            .getAll("d0a2522f1d273c54dc8151cdf8d3644a","us","1","10")
            .map {
                it.message.body.trackContainers.map {
                    Tracks(
                        it.track.trackId,
                        it.track.trackName,
                        it.track.albumName
                    )
                }
            }
    }
}