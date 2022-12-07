package com.example.procyectomovil.model


import android.graphics.Picture
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Category(
    var id : String,
    val categoryName: String,
    val photo:String?

):Parcelable{
    constructor():
            this("","","")
}
