package teknoxera.bisawicara.database

import androidx.room.Dao
import androidx.room.Insert
import teknoxera.bisawicara.data.ImageData

@Dao
interface DBQuery
{
	@Insert
	suspend fun addImage(img : ImageData)
}