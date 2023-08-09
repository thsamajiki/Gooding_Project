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
import androidx.compose.ui.res.painterResource
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
    pages : List<String>
) {
    Row(
        Modifier
        .padding(
            start= dimensionResource(id = R.dimen.margin_tab),
            end= dimensionResource(id = R.dimen.margin_tab),
            top = dimensionResource(id = R.dimen.top_space)
        )) {
        TabRow(
            backgroundColor = Color.Transparent,
            selectedTabIndex = pageState.currentPage,
            divider = {},
            indicator = {tabPositions->
                Box(
                    Modifier
                        .background(Color.Transparent)
                        .padding(bottom = dimensionResource(id = R.dimen.selected_icon_size))
                        .tabIndicatorOffset(tabPositions[pageState.currentPage]),
                    contentAlignment = Alignment.BottomCenter
                ){
                    Text(
                        text = "",
                        modifier = Modifier
                            .background(Color.White, CircleShape)
                            .size(dimensionResource(id = R.dimen.selected_icon_size))
                    )
                }
            },
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.tab_width))
                .height(dimensionResource(id = R.dimen.tab_height))
        ) {
            pages.forEachIndexed { index, title ->
                Tab(
                    text = { Text(text = title) },
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
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                // go search fragment
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                tint = Color.White,
                contentDescription = ""
            )
        }
    }
}