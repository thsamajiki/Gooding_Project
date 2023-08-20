package com.dnd_9th_3_android.gooding.di

import com.dnd_9th_3_android.gooding.data.GalleryLocalDataSource
import com.dnd_9th_3_android.gooding.data.GalleryLocalDataSourceImpl
import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSource
import com.dnd_9th_3_android.gooding.data.KakaoMapAddressRemoteDataSourceImpl
import com.dnd_9th_3_android.gooding.data.SearchFeedListRemoteDataSource
import com.dnd_9th_3_android.gooding.data.SearchFeedListRemoteDataSourceImpl
import com.dnd_9th_3_android.gooding.data.UploadFeedRemoteDataSource
import com.dnd_9th_3_android.gooding.data.UploadFeedRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindGalleryLocalDataSource(
        galleryLocalDataSourceImpl: GalleryLocalDataSourceImpl
    ): GalleryLocalDataSource

    @Singleton
    @Binds
    abstract fun bindSearchFeedListRemoteDataSource(
        searchFeedListRemoteDataSourceImpl: SearchFeedListRemoteDataSourceImpl
    ): SearchFeedListRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindUploadFeedRemoteDataSource(
        uploadFeedRemoteDataSourceImpl: UploadFeedRemoteDataSourceImpl
    ): UploadFeedRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindKakaoMapAddressRemoteDataSource(
        kakaoMapAddressRemoteDataSourceImpl: KakaoMapAddressRemoteDataSourceImpl
    ): KakaoMapAddressRemoteDataSource
}