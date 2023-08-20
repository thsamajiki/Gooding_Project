package com.dnd_9th_3_android.gooding.di

import com.dnd_9th_3_android.gooding.data.repository.feed.UploadFeedRepositoryImpl
import com.dnd_9th_3_android.gooding.data.repository.gallery.GalleryRepository
import com.dnd_9th_3_android.gooding.data.repository.gallery.GalleryRepositoryImpl
import com.dnd_9th_3_android.gooding.data.repository.map.KakaoMapAddressRepository
import com.dnd_9th_3_android.gooding.data.repository.map.KakaoMapAddressRepositoryImpl
import com.dnd_9th_3_android.gooding.data.repository.search.SearchFeedRepository
import com.dnd_9th_3_android.gooding.data.repository.search.SearchFeedRepositoryImpl
import com.dnd_9th_3_android.gooding.data.repository.feed.UploadFeedRepository
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
    abstract fun bindSearchFeedRepositoryImpl(
        searchFeedRepositoryImpl: SearchFeedRepositoryImpl
    ): SearchFeedRepository

    @Singleton
    @Binds
    abstract fun bindUploadFeedRepositoryImpl(
        uploadFeedRepositoryImpl: UploadFeedRepositoryImpl
    ): UploadFeedRepository

    @Singleton
    @Binds
    abstract fun bindKakaoMapAddressRepository(
        kakaoMapAddressRepositoryImpl: KakaoMapAddressRepositoryImpl
    ): KakaoMapAddressRepository
}