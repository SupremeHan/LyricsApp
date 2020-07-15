package android.singidunum.ac.rs.ispitrma.presentation.contract

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.TrackChartResponse
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import androidx.lifecycle.LiveData

interface MainContract {

    interface ViewModel {

        val tracks: LiveData<List<Tracks>>

        fun getTrackChart()
    }
}