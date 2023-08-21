package com.dnd_9th_3_android.gooding.data.model.gallery

import com.dnd_9th_3_android.gooding.presentation.gallery.GalleryUiData

data class GalleryData(
    val id: Long? = -1,
    val mediaType: Int? = -1, // 사진: 1, 동영상: 3
    val mediaData: String = "",
    val duration: Int = 0, // 동영상 재생시간
    val albumName: String = ""
)

fun GalleryData.toUiData(): GalleryUiData {
    return GalleryUiData(
        id = this.id,
        mediaType = this.mediaType,
        mediaData = this.mediaData,
        duration = this.duration
    )
}