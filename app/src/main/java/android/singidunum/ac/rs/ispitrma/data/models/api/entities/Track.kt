package android.singidunum.ac.rs.ispitrma.data.models.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Track(
    @Json(name = "track_id") val trackId: Int,
    @Json(name = "track_name") val trackName: String,
    @Json(name= "album_name") val albumName: String
)