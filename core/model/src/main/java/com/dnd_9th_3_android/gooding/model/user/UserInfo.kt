package com.dnd_9th_3_android.gooding.model.user


import java.io.Serializable

data class UserInfo(
    val name : String,
    val profile : String
) : Serializable