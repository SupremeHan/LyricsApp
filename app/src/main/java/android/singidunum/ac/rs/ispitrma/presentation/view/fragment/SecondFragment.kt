package android.singidunum.ac.rs.ispitrma.presentation.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.presentation.contract.FavouritesContract
import android.singidunum.ac.rs.ispitrma.presentation.view.activity.LyricsActivity
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.adapter.FavouritesAdapter
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff.TrackDiffItemCallBack
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.FavouritesViewModel
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.profile_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SecondFragment : Fragment(R.layout.profile_layout) {

    private val favouritesViewModel : FavouritesContract.ViewModel by viewModel<FavouritesViewModel>()

    private lateinit var favouritesAdapter: FavouritesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initObservers()
        initRecycler()
    }

    private val clickOnLyrics: (Tracks) -> Unit = {
        val intent = Intent(activity, LyricsActivity::class.java)
        intent.putExtra("Tracks",it)
        startActivity(intent)
    }

    private val clickOnDelete: (Tracks) -> Unit = {
        favouritesViewModel.delete(it.trackId.toLong())
        Toast.makeText(activity, "Removed from favourites", Toast.LENGTH_LONG) .show()
    }


    private fun initObservers() {
        favouritesViewModel.favourites.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            favouritesAdapter.submitList(it)
        })
        favouritesViewModel.getAll()
    }

    private fun initRecycler() {
        listaRv.layoutManager = LinearLayoutManager(context)
        favouritesAdapter = FavouritesAdapter(TrackDiffItemCallBack(), clickOnLyrics, clickOnDelete)
        listaRv.adapter = favouritesAdapter
    }
}