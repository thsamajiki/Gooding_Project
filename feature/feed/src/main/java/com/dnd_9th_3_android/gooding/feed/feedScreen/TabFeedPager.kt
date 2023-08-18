package com.dnd_9th_3_android.gooding.feed.feedScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.feature.feed.R
import com.dnd_9th_3_android.gooding.feed.itemFeed.OneFeedItem
import com.dnd_9th_3_android.gooding.feed.viewModel.MainFeedViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

//피드  데이터에 대한 뷰모델 생성
// 각 하나의 피드에 대한 뷰 페이저
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabFeedPager(
    feedViewModel: MainFeedViewModel = viewModel()
) {
    // sample code
    feedViewModel.initFeedData(SampleFeedData.sampleFeedList)
    val verPageState = rememberPagerState() // current feed state -> ver
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        VerticalPager(
            count = feedViewModel.feedList.value!!.size,
            state = verPageState
        ) {page->
            OneFeedItem(feedViewModel.feedList.value!![page])
        }
    }
}