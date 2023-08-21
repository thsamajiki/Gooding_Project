package com.dnd_9th_3_android.gooding.data.repository.gallery

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.dnd_9th_3_android.gooding.data.local.GalleryLocalDataSource
import com.dnd_9th_3_android.gooding.data.model.gallery.AlbumData
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryData
import com.dnd_9th_3_android.gooding.data.paging.GalleryPagingSource
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryImageData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val galleryLocalDataSource: GalleryLocalDataSource
): GalleryRepository {

    override fun getGalleryPagingList(): Flow<PagingData<GalleryData>> {
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
    }

    override fun getAlbumList(): List<AlbumData> {
        return galleryLocalDataSource.getMediaFoldersFromMediaStore(context.contentResolver)
    }
}