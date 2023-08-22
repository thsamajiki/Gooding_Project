package com.dnd_9th_3_android.gooding.feed.feedScreen

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData.sampleThumb
import com.dnd_9th_3_android.gooding.data.video.CheckUrl
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.ImagePainter
import androidx.compose.material.CircularProgressIndicator

// 하나의 동영상 or 이미지 파일
@OptIn(ExperimentalCoilApi::class)
@Composable
fun OneFeedContent(
    contentUrl : String
) {
    // is video check
    val isVideo = CheckUrl.isVideo(contentUrl)
    val painter = if (isVideo) rememberImagePainter(
        data = sampleThumb,
        builder = { crossfade(true) }
    )
    else rememberImagePainter(
        data = contentUrl,
        builder = { crossfade(true) }
    )

    if(!isVideo){
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // loading iamge/video state
            when (painter.state) {
                is ImagePainter.State.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                else -> {}
            }
        }
    }
}