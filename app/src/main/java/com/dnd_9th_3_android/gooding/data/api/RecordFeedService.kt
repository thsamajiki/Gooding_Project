package com.dnd_9th_3_android.gooding.data.api

import com.dnd_9th_3_android.gooding.data.model.UploadFeedResponse
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryData
import retrofit2.http.POST

interface RecordFeedService {
    @POST("api/v1/record/upload")
    suspend fun uploadFeed(

    ): UploadFeedResponse
}