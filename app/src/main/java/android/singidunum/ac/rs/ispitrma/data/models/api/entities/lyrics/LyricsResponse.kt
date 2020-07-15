package android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LyricsResponse(
    val message: LyricsMessage
)