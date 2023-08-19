package com.dnd_9th_3_android.gooding.data.model

data class GalleryData(
    val id: Long? = -1,
    val isSelected: Boolean = false,
    val mediaType: Int? = -1, // 사진: 1, 동영상: 3
    val mediaData: String = "",
    val duration: Int = 0 // 동영상 재생시간
)