package com.dnd_9th_3_android.gooding.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.dnd_9th_3_android.gooding.data.GalleryLocalDataSource
import com.dnd_9th_3_android.gooding.data.GalleryPagingSource
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryImageData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val galleryLocalDataSource: GalleryLocalDataSource
): GalleryRepository {

    override fun getGalleryPagingList(): Flow<PagingData<GalleryImageData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            ),
            pagingSourceFactory = {
                GalleryPagingSource(galleryLocalDataSource)
            }
        )
            .flow
            .map { imageData ->
                imageData.map {
                    it
                }
            }
    }
}