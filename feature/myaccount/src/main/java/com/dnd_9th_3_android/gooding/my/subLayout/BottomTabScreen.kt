package com.dnd_9th_3_android.gooding.my.subLayout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.my.tabLayout.SaveFeedScreen
import com.dnd_9th_3_android.gooding.my.tabLayout.TabTopScreen
import com.dnd_9th_3_android.gooding.my.tabLayout.TimeLineScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.dnd_9th_3_android.gooding.feature.my.R
import com.google.android.material.bottomnavigation.BottomNavigationView

private val pages = listOf("타임라인","저장")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomTabScreen(
    isVisibleTop: Boolean,
    setMaxScreen : ()->Unit //원래 뷰로 돌아가기
){
    val pageState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.tab_background),
                RoundedCornerShape(dimensionResource(id = R.dimen.padding_24))
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_33)))
        // button : 축소
        if (isVisibleTop){
            Box(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.arrow_size))
                    .clickable {
                        setMaxScreen()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    contentDescription = null,
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .width(IntrinsicSize.Max)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_15)))
        }
        // tab selector
        Row {
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
        ) {page ->
            when (page){
                0 -> TimeLineScreen()
                else -> SaveFeedScreen()
            }
        }
    }
}

