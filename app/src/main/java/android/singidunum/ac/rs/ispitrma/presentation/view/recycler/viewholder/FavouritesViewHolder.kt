package android.singidunum.ac.rs.ispitrma.presentation.view.recycler.viewholder

import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fav_tracks_list_item.*

class FavouritesViewHolder (override val containerView: View, clickOnLyrics: (Int) -> Unit,  onDeleteClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        lyricsBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                clickOnLyrics.invoke(adapterPosition)
        }
        deleteBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                onDeleteClicked.invoke(adapterPosition)
        }
    }

    fun bind(tracks: Tracks) {
        songName.text = tracks.trackName
        albumName.text = tracks.albumName
    }
}