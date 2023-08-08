package com.dnd_9th_3_android.gooding.model

import java.io.Serializable

data class Feed(
    val subject : String,
    val content : String,
    val romanticPer : Int,
    val location : String,
    val urlList : List<String>,
    val uploadTime : String,
    val userInfo: UserInfo
): Serializable