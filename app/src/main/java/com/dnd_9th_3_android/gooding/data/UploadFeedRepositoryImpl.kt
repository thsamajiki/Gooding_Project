package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.UploadFeedResponse
import com.dnd_9th_3_android.gooding.data.repository.UploadFeedRepository
import javax.inject.Inject

class UploadFeedRepositoryImpl @Inject constructor(
    private val uploadFeedRemoteDataSource: UploadFeedRemoteDataSource
): UploadFeedRepository {
    override suspend fun uploadFeed(request: RequestUploadFeed): UploadFeedResponse {
        return uploadFeedRemoteDataSource.uploadFeed(request)
    }
}