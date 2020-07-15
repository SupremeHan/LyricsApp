package android.singidunum.ac.rs.ispitrma.presentation.view.activity

import android.os.Bundle
import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.presentation.contract.LyricsContract
import android.singidunum.ac.rs.ispitrma.presentation.viewmodel.LyricsViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.lyrics_layout.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class LyricsActivity: AppCompatActivity(R.layout.lyrics_layout) {

    private lateinit var tracks: Tracks

    private val lyricsViewModel: LyricsContract.ViewModel by viewModel<LyricsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        initObservers()
    }

    private fun init() {
        tracks = intent.getParcelableExtra("Tracks")?:Tracks(0,"","")
        Timber.e(tracks.toString())
    }

    private fun initObservers() {
        lyricsViewModel.lyrics.observe(this, Observer {
            lyricsView.text = it.message.body.lyrics.lyricsBody
        })
        lyricsViewModel.getLyrics(tracks.trackId)
    }
}