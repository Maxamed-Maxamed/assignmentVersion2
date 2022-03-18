package org.wit.dogadoptioncentre.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class AdoptionModel (

    var id: Long = 0,
    var dogName: String = "",
    var dogBreed: String = "",
    var dogLocation: String = "",
    var ratingbar : Float = 0.0f
        ) : Parcelable
