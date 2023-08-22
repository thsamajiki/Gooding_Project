package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.model.feed.Feed
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import com.dnd_9th_3_android.gooding.data.video.CheckUrl
import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.data.contentLayout.bottomGradient
import com.dnd_9th_3_android.gooding.data.contentLayout.topGradient
import com.dnd_9th_3_android.gooding.feed.feedScreen.OneFeedContent
import com.dnd_9th_3_android.gooding.feed.viewModel.MainFeedViewModel

@OptIn(ExperimentalCoilApi::class, ExperimentalFoundationApi::class)
@Composable
fun OneFeedItem(
    feedViewModel: MainFeedViewModel = hiltViewModel(),
    feed: Feed
) {
    feedViewModel.setCurrentFeed(feed)


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ){

        val pagerState = rememberPagerState(pageCount = { feed.urlList.size })
        // feed image list
        HorizontalPager(
            state = pagerState
        ){page->
            OneFeedContent(feed.urlList[page])
        }
        // Image Indi
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_122))
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(feed.urlList.size) { iteration ->
                // iteration color
                val color =
                    if (pagerState.currentPage == iteration) Color.White
                    else colorResource(id = R.color.feed_in_di_back)
                Box(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_2))
                        .clip(CircleShape)
                        .background(color)
                        .size(dimensionResource(id = R.dimen.padding_6))
                )
            }
        }

        // top Box - add shadow
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.top_box_h))
                .align(Alignment.TopCenter)
                .background(
                    brush = topGradient()
                )
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
                .background(
                    brush = bottomGradient()
                )
        ){
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_38)))

            MidInfoLayer(feed.location,feed.subject,feed.content)
        }
    }
}
