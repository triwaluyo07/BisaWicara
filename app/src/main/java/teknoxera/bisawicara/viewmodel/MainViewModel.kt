package teknoxera.bisawicara.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import teknoxera.bisawicara.data.KamusDummy
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.data.TestDummy

class MainViewModel(app : Application) : AndroidViewModel(app)
{
	private lateinit var testHurufId : String

	fun getListHuruf() : List<KamusEntity> = KamusDummy.generateDummyHuruf()
	fun getListAngka() : List<KamusEntity> = KamusDummy.generateDummyAngka()
	fun getTestHuruf() : List<KamusEntity> = TestDummy.generateTestDummyHuruf()

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
}