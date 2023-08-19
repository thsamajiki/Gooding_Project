package com.dnd_9th_3_android.gooding.data.model

import com.google.gson.annotations.SerializedName

data class KakaoMapData(
    @SerializedName("documents") val documents: MutableList<KakaoMapDocuments>,
    @SerializedName("meta") val meta: KakaoMapMeta
)