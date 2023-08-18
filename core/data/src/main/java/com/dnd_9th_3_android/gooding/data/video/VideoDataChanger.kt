package com.dnd_9th_3_android.gooding.data.video

import android.app.Activity
import android.content.Context
import android.media.MediaMetadataRetriever
import android.net.Uri

//object VideoDataChanger {
//    fun getVideoTime(context: Context, videoUrl: Uri?): Long{
//        if (videoUrl!=null) {
//            val retriever = MediaMetadataRetriever()
//            retriever.setDataSource(context,videoUrl)
//            val time  = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
//            val duration = time!!.toLong()/1000
//            val hours = duration/3600
//            val minutes = (duration -hours*3600)/60
//            val seconds = duration - (hours * 3600 + minutes*60)
//            return seconds.toLong()
//        }
//        return 0
//    }
//}