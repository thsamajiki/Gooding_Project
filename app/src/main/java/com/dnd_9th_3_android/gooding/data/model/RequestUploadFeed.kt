package com.dnd_9th_3_android.gooding.data.model

import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryData

data class RequestUploadFeed(
    val thumbnail: String,
    val thumbnailDirectory: String,
    val images: List<GalleryData>,
    val videos: List<GalleryData>,
    val oauthId: String,
    val uploadRequest: UploadRequest
)

data class UploadRequest(
    val title: String,
    val description: String,
    val recordDate: String,
    val placeTitle: String,
    val placeLatitude: Double,
    val placeLongitude: Double,
    val recordOpen: Int,
    val recordScore: String,
)