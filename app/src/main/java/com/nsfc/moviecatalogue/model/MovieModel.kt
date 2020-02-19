package com.nsfc.moviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    var movie_image: Int?,
    var movie_title: String?,
    var movie_date: String?,
    var movie_desc: String?,
    var user_score: String?,
    var movie_studio: String?,
    var movie_director: String?
) : Parcelable