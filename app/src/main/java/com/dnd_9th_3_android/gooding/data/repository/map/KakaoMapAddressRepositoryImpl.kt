package com.dnd_9th_3_android.gooding.data.repository.map

import com.dnd_9th_3_android.gooding.data.remote.map.KakaoMapAddressRemoteDataSource
import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapResponse
import javax.inject.Inject

class KakaoMapAddressRepositoryImpl @Inject constructor(
    private val kakaoMapAddressRemoteDataSource: KakaoMapAddressRemoteDataSource,
) : KakaoMapAddressRepository {
    override suspend fun getKakaoMapAddress(keyword: String): List<KakaoMapResponse> {
        return kakaoMapAddressRemoteDataSource.getKakaoMapAddress(keyword)
    }
}