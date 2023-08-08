package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dnd_9th_3_android.gooding.feature.feed.R
import com.dnd_9th_3_android.gooding.feed.layout.MainTopLayer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
private val pages = listOf("NOW", "추천")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedScreen() {
    Box {
        // 페이지 상태 지정
        val pageState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()
        HorizontalPager(
            count = pages.size,
            state = pageState,
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> NowScreen()
                else -> RecommendScreen()
            }
        }
        // top Layout
        MainTopLayer(pageState,coroutineScope,pages)
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFeed() {
    FeedScreen()
}