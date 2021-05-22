package teknoxera.bisawicara.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class KamusEntity (
    val id: String,
    val imgPoster: Int,
    val description: String
) : Parcelable