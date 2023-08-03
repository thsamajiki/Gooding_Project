package com.dnd_9th_3_android.gooding.api

import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginRetrofitService {
    // for kakao login access token
    @GET("oauth/kakao")
    fun loginKaKao(
        @Query("code")code : String,
    ) : Call<String>
    // for google login access token
    @GET("oauth/google")
    fun loginGoogle(
        @Query("code")code : String,
    ) : Call<String>
}