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
        val pageState = rememberPagerState()
        val coroutineScope = rememberCoroutineScope()
        HorizontalPager(
            count = pages.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> NowScreen()
                else -> RecommendScreen()
            }
        }
        // top Layout
        Row(
            Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.margin_tab),
                    end = dimensionResource(id = R.dimen.margin_tab),
                    top = dimensionResource(id = R.dimen.top_space)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MainTopBarScreen(pageState, coroutineScope, pages)
            Spacer(modifier = Modifier.weight(1f))
            Box(
                Modifier
                    .size(dimensionResource(id = R.dimen.size_24))
                    .clickable {
                        // go search fragment
                    }
            ){
                Image(
                    painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFeed() {
    FeedScreen()
}