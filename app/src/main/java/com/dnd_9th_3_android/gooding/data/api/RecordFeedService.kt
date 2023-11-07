package com.dnd_9th_3_android.gooding.data.api

import com.dnd_9th_3_android.gooding.data.model.feed.UploadFeedResponse
import com.dnd_9th_3_android.gooding.data.model.search.RequestUploadFeed
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface RecordFeedService {
    @Multipart
    @POST("api/v1/record/upload")
    suspend fun uploadFeed(
        @Part thumbnail: MultipartBody.Part,
        @Part thumbnailDirectory: String,
        @Part images: MultipartBody.Part,
        @Part videos: MultipartBody.Part,
        @Part oauthId: String,
        @Part uploadRequest: RequestUploadFeed
    ): UploadFeedResponse
}


//interface RecordFeedService {
//    @Multipart
//    @POST("api/v1/record/upload")
//    suspend fun uploadFeed(
//        @Part thumbnail: MultipartBody.Part,
//        @Part("thumbnailDirectory") thumbnailDirectory: RequestBody,
//        @Part images: List<MultipartBody.Part> = emptyList(),
//        @Part videos: List<MultipartBody.Part> = emptyList(),
//        @Part("oauthId") oauthId: RequestBody,
//        @Part("uploadRequest") uploadRequest: RequestBody
//    ): UploadFeedResponse
//}