package teknoxera.bisawicara.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import teknoxera.bisawicara.data.ImageData
import teknoxera.bisawicara.data.KamusDummy
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.data.TestDummy
import teknoxera.bisawicara.database.DBQuery
import teknoxera.bisawicara.database.ImageDB

class MainViewModel(app : Application) : AndroidViewModel(app)
{
	/*private lateinit var hurufId : String
	private lateinit var angkaId : String*/
	private lateinit var testHurufId : String
	private var db : ImageDB? = ImageDB.getDB(app)
	private var query : DBQuery? = db?.query()

	fun getListHuruf() : List<KamusEntity> = KamusDummy.generateDummyHuruf()
	fun getListAngka() : List<KamusEntity> = KamusDummy.generateDummyAngka()
	fun getTestHuruf() : List<KamusEntity> = TestDummy.generateTestDummyHuruf()
	fun getImage() : LiveData<List<ImageData>>? = query?.getImg()

	fun setTestHurufbyId(testHurufId : String)
	{
		this.testHurufId = testHurufId
	}

	fun getTestHurufbyId() : KamusEntity
	{
		lateinit var kamusEntity : KamusEntity
		val listHuruf = getTestHuruf()
		for (testHuruf in listHuruf)
		{
			if (testHuruf.id == testHurufId)
			{
				kamusEntity = testHuruf
				break
			}
		}
		return kamusEntity
	}

	fun addImage(id : String, img : Int)
	{
		CoroutineScope(Dispatchers.IO)
			.launch {
				query?.addImage(
					ImageData(
						id,
						img
					)
				)
			}
	}
}