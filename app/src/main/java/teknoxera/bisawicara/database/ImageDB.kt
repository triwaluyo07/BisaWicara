package teknoxera.bisawicara.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import teknoxera.bisawicara.data.ImageData

@Database(
	entities = [ImageData::class],
	version = 1
)
abstract class ImageDB : RoomDatabase()
{
	companion object
	{
		private var INS : ImageDB? = null

		fun getDB(con : Context) : ImageDB?
		{
			if (INS == null)
				synchronized(ImageDB::class)
				{
					INS = Room.databaseBuilder(
						con.applicationContext,
						ImageDB::class.java,
						"imageDB"
					).build()
				}
			return INS
		}
	}

	abstract fun query() : DBQuery
}