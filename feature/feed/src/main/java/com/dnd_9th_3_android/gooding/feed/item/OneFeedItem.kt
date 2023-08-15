package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.model.feed.Feed
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import com.dnd_9th_3_android.gooding.feature.feed.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OneFeedItem(feed: Feed) {
    val painter = rememberImagePainter(
        data = feed.urlList[0],
        builder = {
            crossfade(true)
        }
    )

    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        // loading state
        when (painter.state){
            is ImagePainter.State.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            else ->{}
        }

        // in feed content
        Column {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.top_space)))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.tab_height)))
            UserInfoLayer(userInfo = feed.userInfo, uploadTime = feed.uploadTime)
            Divider(modifier = Modifier.weight(1f))
            MidInfoLayer(feed.location,feed.subject,feed.content)
            RomanticBarLayer(feed.romanticPer)
        }
    }
}

@Preview
@Composable
fun PreviewOneFeed(){
    OneFeedItem(SampleFeedData.sampleFeedList[0])
}