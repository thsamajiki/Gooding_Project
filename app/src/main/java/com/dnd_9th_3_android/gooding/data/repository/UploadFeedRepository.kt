package com.dnd_9th_3_android.gooding.data.repository

import com.dnd_9th_3_android.gooding.data.model.FeedData
import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.UploadFeedResponse
import javax.inject.Inject

interface UploadFeedRepository {
    suspend fun uploadFeed(request: RequestUploadFeed): UploadFeedResponse
}