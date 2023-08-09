package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.feature.feed.R
import com.dnd_9th_3_android.gooding.feed.item.OneFeedItem
import com.dnd_9th_3_android.gooding.viewModel.MainFeedViewModel
import com.google.accompanist.pager.VerticalPager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

// 메인 피드 - now
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NowScreen( feedViewModel: MainFeedViewModel = viewModel()) {
    // sample code
    feedViewModel.initFeedData(SampleFeedData.sampleFeedList)
    val state = rememberPagerState() // current feed state
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.type1))
    ) {
        VerticalPager(
            count = feedViewModel.feedList.value!!.size,
            state = state
        ) {page->
            Card {
                OneFeedItem(feedViewModel.feedList.value!![page])
            }
        }
    }
}