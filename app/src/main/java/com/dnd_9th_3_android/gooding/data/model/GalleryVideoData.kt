package com.dnd_9th_3_android.gooding.data.model

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GalleryVideoData(
    val title: String?,
    val path: String?,
    val mimeType: String?,
    val duration: Long,
    val date: Long,
    val size: Long
): Parcelable {
    // 동영상의 썸네일을 반환한다.
    private fun getThumbnail(file_path: String): Bitmap? {
        val thumbnailTime = 1
        val retriever = MediaMetadataRetriever()

        retriever.setDataSource(file_path, HashMap<String,String>())

        return retriever.getFrameAtTime((thumbnailTime * 1000000).toLong(), MediaMetadataRetriever.OPTION_CLOSEST)
    }
}