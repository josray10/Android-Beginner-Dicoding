package com.belajar.android.valorantesportteam

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EsportsTeam (
    val name: String,
    val location: String,
    val region: String,
    val description: String,
    val photo: Int,
    val roster: String
) :Parcelable