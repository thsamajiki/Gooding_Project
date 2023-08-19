package com.dnd_9th_3_android.gooding.api

import com.dnd_9th_3_android.gooding.model.feed.MyFeed
import com.dnd_9th_3_android.gooding.model.feed.MyFeedList
import com.dnd_9th_3_android.gooding.model.user.AccessToken
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query


interface UserApiService {
    @GET("api/v1/record/my-record")
    fun getMyRecords(
        @Query("userId") userId: Int,
    ) : Call<Unit>
}
