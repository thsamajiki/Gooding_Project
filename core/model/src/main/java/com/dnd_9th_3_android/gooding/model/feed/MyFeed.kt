package com.dnd_9th_3_android.gooding.model.feed

import java.io.Serializable


data class MyFeed (
    val id : Int,
    val title : String,
    val description : String,
    val recordDate : String,
    val placeTitle : String,
    val placeLatitude : Double,
    val placeLongitude : Double,
    val recordScore : Int,
    val recordOpen : String,
    val thumbnailId : String,
    val files : ArrayList<FileData>
) : Serializable