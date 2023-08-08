package com.dnd_9th_3_android.gooding.di

import com.dnd_9th_3_android.gooding.data.GalleryLocalDataSource
import com.dnd_9th_3_android.gooding.data.GalleryLocalDataSourceImpl
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
    abstract fun bindGalleryLocalDataSource(galleryLocalDataSourceImpl : GalleryLocalDataSourceImpl) : GalleryLocalDataSource
}