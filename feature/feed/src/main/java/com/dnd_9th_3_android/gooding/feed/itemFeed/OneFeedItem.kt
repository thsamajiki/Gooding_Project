package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.model.feed.Feed
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import com.dnd_9th_3_android.gooding.data.video.CheckUrl
import com.dnd_9th_3_android.gooding.core.data.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OneFeedItem(feed: Feed) {
    // is video check
    val painter = if (CheckUrl.isVideo(feed.urlList[0])) rememberImagePainter(
        data = SampleFeedData.sampleThumb[0],
        builder = { crossfade(true) }
    )
    else rememberImagePainter(
        data = feed.urlList[0],
        builder = { crossfade(true) }
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ){
        // first image load
        Image(
            painter = painter, contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // loading iamge/video state
        when (painter.state){
            is ImagePainter.State.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            else ->{}
        }

        // top Box - add shadow
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.top_box_h))
                .align(Alignment.TopCenter)
        ){
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.top_padding)))

            UserInfoLayer(userInfo = feed.userInfo)
        }

        // bottom Box - add shadow
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.bottom_box_h))
                .align(Alignment.BottomCenter)
        ){
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_38)))

            MidInfoLayer(feed.location,feed.subject,feed.content)
        }
    }
}

@Preview
@Composable
fun PreviewOneFeed(){
    OneFeedItem(SampleFeedData.sampleFeedList[0])
}