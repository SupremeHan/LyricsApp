package android.singidunum.ac.rs.ispitrma.data.models.api.entities

import android.singidunum.ac.rs.ispitrma.data.models.api.base_entities.Header
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackMessage(
    val header: Header,
    val body: TrackBody
)