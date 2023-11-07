package com.dnd_9th_3_android.gooding.data.model.map

import com.dnd_9th_3_android.gooding.data.model.map.KakaoMapDocuments

data class KakaoMapData(
    val documents: List<KakaoMapDocuments>,
    val meta: KakaoMapMeta
)