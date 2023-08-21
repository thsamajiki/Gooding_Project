package com.dnd_9th_3_android.gooding.data.repository.gallery

import androidx.paging.PagingData
import com.dnd_9th_3_android.gooding.data.model.gallery.AlbumData
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryData
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryImageData
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    fun getGalleryPagingList(): Flow<PagingData<GalleryData>>

    fun getAlbumList(): List<AlbumData>
}