package com.dnd_9th_3_android.gooding.my.tabLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendard
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabTopScreen(
    pageState: PagerState,
    coroutineScope: CoroutineScope,
    pages: List<String>
) {
    ScrollableTabRow(
        backgroundColor = Color.Transparent,
        selectedTabIndex = pageState.currentPage,
        divider = {},
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            Box(
                Modifier
                    .background(Color.Transparent)
                    .tabIndicatorOffset(tabPositions[pageState.currentPage]),
                contentAlignment = Alignment.BottomCenter
            ){
                // line indicator
                Divider(
                    modifier = Modifier
                        .background(Color.White)
                        .height(dimensionResource(id = R.dimen.border_size_2))
                )
            }

        },
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        fontSize = dimensionResource(id = R.dimen.text_16_sp).value.sp,
                        fontFamily = pretendard

                    )
                },
                selected = pageState.currentPage == index,
                selectedContentColor = Color.White,
                unselectedContentColor = colorResource(id = R.color.unselect_tab),
                onClick = {
                    coroutineScope.launch {
                        pageState.scrollToPage(index)
                    }
                }
            )
        }
    }

}
