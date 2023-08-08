package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.GalleryImageData

interface GalleryLocalDataSource {
    suspend fun getAllImages(page: Int): List<GalleryImageData>
}