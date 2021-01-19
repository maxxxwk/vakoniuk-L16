package com.maxxxwk.viewpager

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(val name: String, val population: Double, val square: Double) : Parcelable {
    val populationDensity = population / square
}