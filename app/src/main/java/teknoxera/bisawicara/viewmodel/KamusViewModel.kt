package teknoxera.bisawicara.viewmodel

import androidx.lifecycle.ViewModel
import teknoxera.bisawicara.data.KamusDummy
import teknoxera.bisawicara.data.KamusEntity
import teknoxera.bisawicara.data.TestDummy

class KamusViewModel : ViewModel() {

    private lateinit var hurufId: String
    private lateinit var angkaId: String
    private lateinit var testHurufId : String

    fun getListHuruf() : List<KamusEntity> = KamusDummy.generateDummyHuruf()
    fun getListAngka() : List<KamusEntity> = KamusDummy.generateDummyAngka()
    fun getTestHuruf() : List<KamusEntity> = TestDummy.generateTestDummyHuruf()
}