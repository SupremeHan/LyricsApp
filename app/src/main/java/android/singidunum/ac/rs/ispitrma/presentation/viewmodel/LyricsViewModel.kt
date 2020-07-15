package android.singidunum.ac.rs.ispitrma.presentation.viewmodel

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import android.singidunum.ac.rs.ispitrma.data.repository.LyricsRepository
import android.singidunum.ac.rs.ispitrma.presentation.contract.LyricsContract
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class LyricsViewModel(
    private val lyricsRepository: LyricsRepository
): ViewModel() ,LyricsContract.ViewModel {
    override val lyrics: MutableLiveData<LyricsResponse> = MutableLiveData()

    private val subscriptions = CompositeDisposable()

    override fun getLyrics(trackId: Int) {
        val subscription = lyricsRepository
            .getLyrics(trackId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    lyrics.value = it
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