package com.example.gamebacklog.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
class Game (
    var title: String,
    var platform : String,
    var releaseDate: Long
) : Parcelable