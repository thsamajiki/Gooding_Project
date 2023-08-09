package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.feed.layout.MainTopBarScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

private val pages = listOf("NOW", "추천")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedScreen() {
    Box {
        // 페이지 상태 지정 ( now - 추천 가로 페이징 )
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
        MainTopBarScreen(pageState,coroutineScope,pages)
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFeed() {
    FeedScreen()
}