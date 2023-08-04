package com.dnd_9th_3_android.gooding.api

import com.dnd_9th_3_android.gooding.model.AccessToken
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface LoginRetrofitService {
    // for kakao login access token
    @GET("oauth/kakao")
    fun loginKaKao(
        @Query("accessToken")code : String,
    ) : Call<AccessToken>
    // for google login access token
    @GET("oauth/google")
    fun loginGoogle(
        @Query("code")code : String,
    ) : Call<AccessToken>
}