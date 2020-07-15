package android.singidunum.ac.rs.ispitrma.data.models.api.entities.lyrics

import android.singidunum.ac.rs.ispitrma.data.models.api.base_entities.Header
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LyricsMessage(
    val header: Header,
    val body: LyricsBody
)