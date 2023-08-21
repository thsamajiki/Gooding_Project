package com.dnd_9th_3_android.gooding.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dnd_9th_3_android.gooding.data.local.GalleryLocalDataSource
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryData

class GalleryPagingSource(
    private val galleryLocalDataSource: GalleryLocalDataSource
) : PagingSource<Int, GalleryData>() {

    override fun getRefreshKey(state: PagingState<Int, GalleryData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryData> {
        val page = params.key ?: FIRST_PAGE
        val data = galleryLocalDataSource.getImageVideoFromGallery(page, params.loadSize)
//        val data = galleryLocalDataSource.fetchGalleryImages(params.loadSize, page*params.loadSize)
//        val endOfPaginationReached = (data.size ?: 0) == 0
//
//        val prevKey = if (pageNumber == FIRST_PAGE) null else pageNumber - 1
//        val nextKey = if (endOfPaginationReached) {
//            null
//        } else {
//            pageNumber + (params.loadSize / PAGING_SIZE)
//        }

        return LoadResult.Page(
            data = data,
            prevKey = null,
            nextKey = if (data.isNotEmpty()) page + 1 else null
        )
    }

    companion object {
        const val FIRST_PAGE = 0
    }
}