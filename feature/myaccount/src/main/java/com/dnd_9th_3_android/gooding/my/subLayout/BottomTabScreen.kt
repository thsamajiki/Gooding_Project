package com.dnd_9th_3_android.gooding.my.subLayout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.my.tabLayout.SaveFeedScreen
import com.dnd_9th_3_android.gooding.my.tabLayout.TabTopScreen
import com.dnd_9th_3_android.gooding.my.tabLayout.TimeLineScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.dnd_9th_3_android.gooding.feature.my.R

private val pages = listOf("타임라인","저장")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomTabScreen(
    lazyState: LazyListState
){
    val pageState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.tab_background),
                RoundedCornerShape(dimensionResource(id = R.dimen.padding_24))
            )
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_33)))
        // tab selector
        Row(
            Modifier.clickable {
                Log.d("state1 : ",lazyState.firstVisibleItemScrollOffset.toString())

            }
        ){
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_18)))
            TabTopScreen(
                pageState = pageState,
                coroutineScope = coroutineScope,
                pages = pages
            )
        }
        // line indicator
        Divider(
            modifier = Modifier
                .background(colorResource(id = R.color.blue_gray))
                .height(dimensionResource(id = R.dimen.border_size))
        )
        // tab pager
        HorizontalPager(
            count = pages.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {page ->
            when (page){
                0 -> TimeLineScreen()
                else -> SaveFeedScreen()
            }
        }
    }
}

