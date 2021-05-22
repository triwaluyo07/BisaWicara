package teknoxera.bisawicara

import teknoxera.bisawicara.data.KamusEntity

interface ItemCallback {
    fun onItemClicked(data: KamusEntity)
}