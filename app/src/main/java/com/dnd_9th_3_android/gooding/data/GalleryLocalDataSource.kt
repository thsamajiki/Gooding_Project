package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.GalleryData
import com.dnd_9th_3_android.gooding.data.model.GalleryImageData
import com.dnd_9th_3_android.gooding.data.model.GalleryVideoData

interface GalleryLocalDataSource {
    fun getAllImages(page: Int): List<GalleryImageData>

    fun getAllVideos(page: Int): List<GalleryVideoData>

    fun getImageVideoFromGallery(): List<GalleryData>

//    suspend fun fetchGalleryImages(limit: Int, offset: Int): List<GalleryImageData>
}