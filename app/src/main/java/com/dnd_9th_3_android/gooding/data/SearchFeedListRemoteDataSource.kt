package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.model.PopularKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.RecentKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.SearchFeedListResponse

interface SearchFeedListRemoteDataSource {
    suspend fun searchFeedList(page: Int, query: String): SearchFeedListResponse

    suspend fun getRecentKeywordList(): RecentKeywordListResponse

    suspend fun getPopularKeywordList(): PopularKeywordListResponse

    suspend fun addRecentKeywordList()

    suspend fun deleteRecentKeywordList()
}