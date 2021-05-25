package teknoxera.bisawicara.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_process")
data class ImageData(
	@PrimaryKey var id : String,
	var img : Int
)