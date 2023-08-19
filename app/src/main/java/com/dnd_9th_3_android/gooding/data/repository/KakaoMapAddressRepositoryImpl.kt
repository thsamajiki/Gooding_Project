package com.dnd_9th_3_android.gooding.data.repository

import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSource
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapData
import javax.inject.Inject

class KakaoMapAddressRepositoryImpl @Inject constructor(
    private val kakaoMapAddressRemoteDataSource: KakaoMapAddressRemoteDataSource,
) : KakaoMapAddressRepository {
    override suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapData> {
        return kakaoMapAddressRemoteDataSource.getKakaoMapAddress(keyword)
    }
}