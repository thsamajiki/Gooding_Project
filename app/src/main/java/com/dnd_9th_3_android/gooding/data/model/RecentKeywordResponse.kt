package com.dnd_9th_3_android.gooding.data.model

import com.google.gson.annotations.SerializedName

data class RecentFeedResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("content") val content: Int,
)

fun RecentFeedResponse.toEntity(): RecentKeywordData {
    return RecentKeywordData(
        id = id,
        content = content
    )
}