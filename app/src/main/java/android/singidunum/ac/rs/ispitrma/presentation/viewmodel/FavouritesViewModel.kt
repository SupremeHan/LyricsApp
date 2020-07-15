package android.singidunum.ac.rs.ispitrma.presentation.viewmodel

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics.LyricsResponse
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.data.repository.FavouritesRepository
import android.singidunum.ac.rs.ispitrma.data.repository.LyricsRepository
import android.singidunum.ac.rs.ispitrma.presentation.contract.FavouritesContract
import android.singidunum.ac.rs.ispitrma.presentation.contract.LyricsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class FavouritesViewModel(
    private val favouritesRepository: FavouritesRepository
): ViewModel() , FavouritesContract.ViewModel {
    override val favourites: MutableLiveData<List<Tracks>> = MutableLiveData()

    private val subscriptions = CompositeDisposable()


    override fun getAll() {
        val subscription = favouritesRepository
            .getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    favourites.value = it
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun delete(id: Long) {
        val subscription = favouritesRepository
            .delete(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("Uspesno obrisano")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun insert(tracks: Tracks) {
        val subscription = favouritesRepository
            .insert(tracks)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                   Timber.e("Uspesno dodato")
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