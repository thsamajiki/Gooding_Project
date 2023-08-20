package com.dnd_9th_3_android.gooding.data.model

import com.google.gson.annotations.SerializedName

data class PopularKeywordResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("content") val content: String,
    @SerializedName("searchedCount") val searchedCount: Int
)

fun PopularKeywordResponse.toEntity(): PopularKeywordData {
    return PopularKeywordData(
        id = id,
        content = content,
        searchedCount = searchedCount
    )
}