package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.UploadFeedResponse

interface UploadFeedRemoteDataSource {
    suspend fun uploadFeed(request: RequestUploadFeed): UploadFeedResponse
}