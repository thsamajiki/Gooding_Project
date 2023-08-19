package com.dnd_9th_3_android.gooding

import com.dnd_9th_3_android.gooding.data.model.KakaoMapData
import retrofit2.http.GET
import retrofit2.http.Query

// 카카오맵 api Service
interface KakaoMapService {
    @GET("v2/local/search/address")
    suspend fun getKakaoMapAddress(
        @Query("query") input: String  // 검색 키워드
    ): List<KakaoMapData>
}