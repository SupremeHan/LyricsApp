package android.singidunum.ac.rs.ispitrma.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class TracksEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val trackId: Int,
    val trackName: String,
    val trackAlbumName: String
)