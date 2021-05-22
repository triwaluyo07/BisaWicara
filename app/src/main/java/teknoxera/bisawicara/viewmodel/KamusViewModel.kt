package teknoxera.bisawicara.viewmodel

import androidx.lifecycle.ViewModel
import teknoxera.bisawicara.data.KamusDummy
import teknoxera.bisawicara.data.KamusEntity

class KamusViewModel : ViewModel() {

    private lateinit var hurufId: String
    private lateinit var angkaId: String

    fun getListHuruf() : List<KamusEntity> = KamusDummy.generateDummyHuruf()
    fun getListAngka() : List<KamusEntity> = KamusDummy.generateDummyAngka()
}