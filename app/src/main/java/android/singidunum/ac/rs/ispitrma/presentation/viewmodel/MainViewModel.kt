package android.singidunum.ac.rs.ispitrma.presentation.viewmodel


import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.data.repository.TrackChartRepository
import android.singidunum.ac.rs.ispitrma.presentation.contract.MainContract
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainViewModel (
    private val trackChratRepository: TrackChartRepository
): ViewModel(), MainContract.ViewModel {
    override val tracks: MutableLiveData<List<Tracks>> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun getTrackChart() {
        val subscription = trackChratRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    tracks.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun onCleared() {
        subscriptions.dispose()
        super.onCleared()
    }

}