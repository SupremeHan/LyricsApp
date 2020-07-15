package android.singidunum.ac.rs.ispitrma.data.models.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackBody(
    @Json(name = "track_list") val trackContainers: List<TrackContainer>
)