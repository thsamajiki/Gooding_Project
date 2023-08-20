package com.dnd_9th_3_android.gooding.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.dnd_9th_3_android.gooding.data.SearchFeedListPagingSource
import com.dnd_9th_3_android.gooding.data.SearchFeedListRemoteDataSource
import com.dnd_9th_3_android.gooding.data.model.FeedData
import com.dnd_9th_3_android.gooding.data.model.PopularKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.RecentKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.RequestUploadFeed
import com.dnd_9th_3_android.gooding.data.model.SearchFeedData
import com.dnd_9th_3_android.gooding.data.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface SearchFeedRepository {
    fun searchFeedRepository(query: String): Flow<PagingData<SearchFeedData>>

    suspend fun getRecentKeywordList(): RecentKeywordListResponse

    suspend fun getPopularKeywordList(): PopularKeywordListResponse

    suspend fun addRecentKeywordList()

    suspend fun deleteRecentKeywordList()
}