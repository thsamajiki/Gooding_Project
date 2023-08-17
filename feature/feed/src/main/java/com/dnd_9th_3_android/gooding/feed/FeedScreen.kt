package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.feature.feed.R
import com.dnd_9th_3_android.gooding.feed.layout.MainTopBarScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.Alignment

private val pages = listOf("NOW", "추천")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedScreen() {
    Box {
        // 페이지 상태 지정 ( now - 추천 가로 페이징 )
        val hoPageState = rememberPagerState()
        HorizontalPager(
            count = pages.size,
            state = hoPageState,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> NowScreen(hoPageState)
                else -> RecommendScreen()
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFeed() {
    FeedScreen()
}