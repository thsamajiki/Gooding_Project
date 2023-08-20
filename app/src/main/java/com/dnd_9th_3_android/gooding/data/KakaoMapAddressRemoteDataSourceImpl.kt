package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.api.KakaoMapService
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapResponse
import javax.inject.Inject

class KakaoMapAddressRemoteDataSourceImpl @Inject constructor(
    private val kakaoMapService: KakaoMapService
) : KakaoMapAddressRemoteDataSource {
    override suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapResponse> {
        return kakaoMapService.getKakaoMapAddress(keyword)
    }
}