package android.singidunum.ac.rs.ispitrma.presentation.view.recycler.viewholder


import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_track_list_item.*
import timber.log.Timber

class TrackViewHolder(override val containerView: View, clickOnLyrics: (Int) -> Unit, clickOnFav: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(tracks: Tracks) {
        trackName.text = tracks.trackName
        trackAlbumName.text = tracks.albumName
        Timber.e("Porukaaaaaaaaa")
    }

    init {
        lyricsButton.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                clickOnLyrics.invoke(adapterPosition)
        }
        favouriteButton.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION)
                clickOnFav.invoke(adapterPosition)
        }
    }
}