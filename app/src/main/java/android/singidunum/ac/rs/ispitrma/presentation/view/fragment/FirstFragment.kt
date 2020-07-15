package android.singidunum.ac.rs.ispitrma.presentation.view.fragment

import android.content.Intent
import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.presentation.contract.FavouritesContract
import android.singidunum.ac.rs.ispitrma.presentation.contract.MainContract
import android.singidunum.ac.rs.ispitrma.presentation.view.activity.LyricsActivity
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.adapter.TrackAdapter
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff.TrackDiffItemCallBack
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.FavouritesViewModel
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.MainViewModel
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class FirstFragment : Fragment(R.layout.fragment_first) {
    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()
    private val favouritesViewModel: FavouritesContract.ViewModel by viewModel<FavouritesViewModel>()

    private lateinit var trackAdapter: TrackAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
    }

    private fun initUi() {
        initRecycler()
        initObservers()
    }
    private fun initObservers() {
        mainViewModel.tracks.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            trackAdapter.submitList(it)

        })
        mainViewModel.getTrackChart()
    }

    private val clickOnLyrics: (Tracks) -> Unit = {
        val intent = Intent(activity,LyricsActivity::class.java)
        intent.putExtra("Tracks",it)
        startActivity(intent)
    }

    private val clickOnFavourite: (Tracks) -> Unit = {
        favouritesViewModel.insert(it)
        Toast.makeText(activity, "Added to favoutite", Toast.LENGTH_LONG) .show()
    }


    private fun initRecycler() {
        listRv.layoutManager = LinearLayoutManager(context)
        trackAdapter = TrackAdapter(TrackDiffItemCallBack(), clickOnLyrics, clickOnFavourite)
        listRv.adapter = trackAdapter
    }

}