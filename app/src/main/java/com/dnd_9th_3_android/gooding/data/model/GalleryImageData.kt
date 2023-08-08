package com.dnd_9th_3_android.gooding.data.model

import android.net.Uri

data class GalleryImageData(
    val uri: Uri,
    val name: String,
    val fullName: String,
    val mimeType: String,
    val addedDate: Long,
    val folder: String,
    val size: Long,
    val width: Int,
    val height: Int
)