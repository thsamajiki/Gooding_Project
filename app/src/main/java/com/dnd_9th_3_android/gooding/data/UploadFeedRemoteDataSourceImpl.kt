package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.api.RecordFeedService
import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.UploadFeedResponse
import javax.inject.Inject

class UploadFeedRemoteDataSourceImpl @Inject constructor(
    private val recordFeedService: RecordFeedService
): UploadFeedRemoteDataSource {
    override suspend fun uploadFeed(request: RequestUploadFeed): UploadFeedResponse {
        return recordFeedService.uploadFeed()
    }
}