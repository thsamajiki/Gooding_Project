package com.dnd_9th_3_android.gooding.data

import com.dnd_9th_3_android.gooding.data.api.SearchFeedService
import com.dnd_9th_3_android.gooding.data.model.PopularKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.RecentKeywordListResponse
import com.dnd_9th_3_android.gooding.data.model.SearchFeedListResponse
import javax.inject.Inject

class SearchFeedListRemoteDataSourceImpl @Inject constructor(
    private val searchFeedService: SearchFeedService
): SearchFeedListRemoteDataSource {
    override suspend fun searchFeedList(page: Int, query: String): SearchFeedListResponse {
        return searchFeedService.searchFeedList(page, query)
    }

    override suspend fun getRecentKeywordList(): RecentKeywordListResponse {
        return searchFeedService.getRecentKeywordList()
    }

    override suspend fun getPopularKeywordList(): PopularKeywordListResponse {
        return searchFeedService.getPopularKeywordList()
    }

    override suspend fun addRecentKeywordList() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRecentKeywordList() {
        TODO("Not yet implemented")
    }
}