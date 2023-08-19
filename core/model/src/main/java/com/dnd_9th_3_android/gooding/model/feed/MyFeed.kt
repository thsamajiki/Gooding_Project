package com.dnd_9th_3_android.gooding.model.feed

import java.io.Serializable


data class MyFeed (
    val id : Int,
//    val title : String,
    val description : String,
    val recordDate : String,
    val placeTitle : String,
    val placeLatitude : Int,
    val placeLongitude : Int,
    val recordScore : Int,
    val recordOpen : String,
    val files : ArrayList<FileData>
) : Serializable