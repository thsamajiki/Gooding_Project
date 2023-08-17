package com.dnd_9th_3_android.gooding.feed.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.dnd_9th_3_android.gooding.data.feed.pages
import com.dnd_9th_3_android.gooding.feature.feed.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainTopBarScreen (
    pageState: PagerState,
    coroutineScope: CoroutineScope,
) {
        ScrollableTabRow(
            backgroundColor = Color.Transparent,
            selectedTabIndex = pageState.currentPage,
            divider = {},
            edgePadding = 0.dp,
            modifier = Modifier.width(200.dp),
            indicator = {tabPositions->
                Box(
                    Modifier
                        .background(Color.Transparent)
                        .tabIndicatorOffset(tabPositions[pageState.currentPage]),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Text(
                        text = "",
                        modifier = Modifier
                            .background(Color.White, CircleShape)
                    )
                }
            }
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title, modifier = Modifier.wrapContentSize()) },
                    selected = pageState.currentPage == index,
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.DarkGray,
                    onClick = {
                        coroutineScope.launch {
                            pageState.scrollToPage(index)
                        }
                    }
                )
            }
        }
}