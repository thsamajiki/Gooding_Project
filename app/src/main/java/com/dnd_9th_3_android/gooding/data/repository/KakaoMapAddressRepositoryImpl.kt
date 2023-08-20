package com.dnd_9th_3_android.gooding.data.repository

import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSource
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapData
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapResponse
import com.dnd_9th_3_android.gooding.data.model.map.toEntity
import javax.inject.Inject

class KakaoMapAddressRepositoryImpl @Inject constructor(
    private val kakaoMapAddressRemoteDataSource: KakaoMapAddressRemoteDataSource,
) : KakaoMapAddressRepository {
    override suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapResponse> {
        return kakaoMapAddressRemoteDataSource.getKakaoMapAddress(keyword)
    }
}