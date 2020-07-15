package android.singidunum.ac.rs.ispitrma.data.models.api.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TrackChartResponse(
    val message: TrackMessage
)