package android.singidunum.ac.rs.ispitrma.presentation.view.recycler.adapter

import android.singidunum.ac.rs.ispitrma.R
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff.TrackDiffItemCallBack
import android.singidunum.ac.rs.ispitrma.presentation.view.recycler.viewholder.FavouritesViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class FavouritesAdapter(tracksDiffItemCallBack: TrackDiffItemCallBack,
                        private val clickOnLyrics: (Tracks) -> Unit,
                        private val onDeleteClicked: (Tracks) -> Unit
                        ) : ListAdapter<Tracks, FavouritesViewHolder>(tracksDiffItemCallBack) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.fav_tracks_list_item, parent, false)
        return FavouritesViewHolder(containerView, functionOnLyrics, functionDelete)
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val tracks = getItem(position)
        holder.bind(tracks)
    }

    private val functionOnLyrics: (Int) -> Unit =  {
        if (it >= 0) {
            val lyrics = getItem(it)
            clickOnLyrics.invoke(lyrics)
        }
    }

    private val functionDelete: (Int) -> Unit =  {
        if (it >= 0) {
            val tracks = getItem(it)
            onDeleteClicked.invoke(tracks)
        }
    }

}