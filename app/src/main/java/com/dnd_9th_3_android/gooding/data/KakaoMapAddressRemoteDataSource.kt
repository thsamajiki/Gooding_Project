package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapResponse

interface KakaoMapAddressRemoteDataSource {
    suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapResponse>
}