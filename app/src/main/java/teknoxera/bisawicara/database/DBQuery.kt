package teknoxera.bisawicara.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import teknoxera.bisawicara.data.ImageData

@Dao
interface DBQuery
{
	@Insert
	suspend fun addImage(img : ImageData)

	@Query("SELECT * FROM image_process")
	fun getImg() : LiveData<List<ImageData>>
}