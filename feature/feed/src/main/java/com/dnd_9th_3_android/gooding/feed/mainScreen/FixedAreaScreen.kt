package com.dnd_9th_3_android.gooding.feed.mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.feed.fixedAreaSubLayout.FeedTopLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import androidx.compose.foundation.Image
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource

import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.feed.itemFeed.RomanticBarLayer

// main 고정 화면
// Fixed는 Box를 사용하므로, 자체 패딩 꼭 추가 !!
@OptIn(ExperimentalPagerApi::class)
@Composable
fun FixedAreaScreen(
    hoPageState :PagerState
) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        // top menu
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ){
            FeedTopLayout(pageState = hoPageState, coroutineScope = coroutineScope)
        }

        // book mark
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = dimensionResource(id = R.dimen.book_padding_bottom),
                    end = dimensionResource(id = R.dimen.padding_16)
                )
                .size(dimensionResource(id = R.dimen.padding_24))
        ){
            Image(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription =null ,
                modifier = Modifier.fillMaxSize()
            )
        }

        // romantic per
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            RomanticBarLayer(romanticPer = 0)
        }
    }
}