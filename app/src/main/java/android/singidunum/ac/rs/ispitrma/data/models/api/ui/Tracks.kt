package android.singidunum.ac.rs.ispitrma.data.models.api.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tracks(
    val trackId: Int,
    val trackName: String,
    val albumName: String
): Parcelable