package com.dnd_9th_3_android.gooding.feed.fixedAreaSubLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.feed.layout.TopScrollBarLayer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope

// 스크롤 뷰를 퐇마한 상단 데이터
@OptIn(ExperimentalPagerApi::class)
@Composable
fun FeedTopLayout(
    pageState: PagerState,
    coroutineScope: CoroutineScope
) {
    // top Layout
    Row(
        Modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_18),
                end = dimensionResource(id = R.dimen.padding_16),
                top = dimensionResource(id = R.dimen.padding_55),
                bottom = dimensionResource(id = R.dimen.padding_13)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // top bar .. !
        TopScrollBarLayer(pageState, coroutineScope)

        Spacer(modifier = Modifier.weight(1f))

        // search button
        Box(
            Modifier
                .size(dimensionResource(id = R.dimen.padding_24))
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