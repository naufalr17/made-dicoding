package com.nsfc.moviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SerialModel(
    var serial_image: Int?,
    var serial_title: String?,
    var serial_date: String?,
    var serial_desc: String?,
    var serial_user_score: String?,
    var serial_studio: String?,
    var serial_director: String?
) : Parcelable