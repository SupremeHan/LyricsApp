package android.singidunum.ac.rs.ispitrma.presentation.view.recycler.diff

import android.singidunum.ac.rs.ispitrma.data.models.api.entities.Track
import android.singidunum.ac.rs.ispitrma.data.models.api.ui.Tracks
import androidx.recyclerview.widget.DiffUtil

class TrackDiffItemCallBack : DiffUtil.ItemCallback<Tracks>() {
    override fun areItemsTheSame(oldItem: Tracks, newItem: Tracks): Boolean {
        return oldItem.trackId == newItem.trackId
    }

    override fun areContentsTheSame(oldItem: Tracks, newItem: Tracks): Boolean {
        return oldItem.trackName == newItem.trackName && oldItem.albumName == newItem.albumName

    }

}