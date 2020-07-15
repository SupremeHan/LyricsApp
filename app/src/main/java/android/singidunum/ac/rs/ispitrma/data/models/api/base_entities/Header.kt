package android.singidunum.ac.rs.ispitrma.data.models.api.base_entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Header(
    @Json(name = "status_code") val statusCode: Int,
    @Json(name ="execute_time") val time: Double
)