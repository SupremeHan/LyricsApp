package android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LyricsContainer(
    @Json(name = "lyrics_id") val lyricsId: Int,
    @Json(name = "lyrics_body") val lyricsBody: String
)