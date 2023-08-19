package com.dnd_9th_3_android.gooding.data.repository

import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapData

interface KakaoMapAddressRepository {
    suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapData>
}