package com.example.gamebacklog.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity
class Game (
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var title: String,
    var platform : String,
    var releaseDate: Date
) : Parcelable