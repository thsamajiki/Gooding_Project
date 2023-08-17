package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.model.feed.Feed
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.dnd_9th_3_android.gooding.feature.feed.R

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
            .background(Color.White)
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
        // top shadow
        Image(
            painter = painterResource(id = R.drawable.top_shadow),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.TopCenter)
        )
        // bottom shadow
        Image(
            painter = painterResource(id = R.drawable.bottom_shadow),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
        )

        // in feed content
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.top_space)))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.tab_height)))
            UserInfoLayer(userInfo = feed.userInfo, uploadTime = feed.uploadTime)
            Divider(modifier = Modifier.weight(1f))
            MidInfoLayer(feed.location,feed.subject,feed.content)
        }
    }
}

@Preview
@Composable
fun PreviewOneFeed(){
    OneFeedItem(SampleFeedData.sampleFeedList[0])
}