package android.singidunum.ac.rs.ispitrma.presentation.view.recycler.adapter

import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff.TrackDiffItemCallBack
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.viewholder.TrackViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class TrackAdapter(
    trackDiffItemCallBack: TrackDiffItemCallBack,
    private val clickOnLyrics: (Tracks) -> Unit,
    private val clickOnFav: (Tracks) -> Unit) : ListAdapter<Tracks, TrackViewHolder>(trackDiffItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.layout_track_list_item, parent,false)
        return TrackViewHolder(containerView, functionOnLyrics, functionOnFav)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val tracks = getItem(position)
        holder.bind(tracks)
    }

    private val functionOnLyrics: (Int) -> Unit =  {
        if (it >= 0) {
            val lyrics = getItem(it)
            clickOnLyrics.invoke(lyrics)
        }
    }

    private val functionOnFav: (Int) -> Unit =  {
        if (it >= 0) {
            val fav = getItem(it)
            clickOnFav.invoke(fav)
        }
    }
}