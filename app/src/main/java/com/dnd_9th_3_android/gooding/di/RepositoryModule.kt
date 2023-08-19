package com.dnd_9th_3_android.gooding.di

import com.dnd_9th_3_android.gooding.data.repository.GalleryRepository
import com.dnd_9th_3_android.gooding.data.repository.GalleryRepositoryImpl
import com.dnd_9th_3_android.gooding.data.repository.KakaoMapAddressRepository
import com.dnd_9th_3_android.gooding.data.repository.KakaoMapAddressRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindGalleryRepository(
        galleryRepositoryImpl: GalleryRepositoryImpl
    ): GalleryRepository

    @Singleton
    @Binds
    abstract fun bindKakaoMapAddressRepository(
        kakaoMapAddressRepositoryImpl: KakaoMapAddressRepositoryImpl
    ): KakaoMapAddressRepository
}