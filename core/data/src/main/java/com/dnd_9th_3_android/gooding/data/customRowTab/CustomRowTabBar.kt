package com.dnd_9th_3_android.gooding.data.contentLayout

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.data.customRowTab.CustomText
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

// size 조절 참고
//https://stackoverflow.com/questions/76503595/reduce-spacing-between-scrollable-tabs-in-compose/76533630#76533630
//https://stackoverflow.com/questions/76503595/reduce-spacing-between-scrollable-tabs-in-compose/76533630#76533630
@OptIn(ExperimentalPagerApi::class)
@SuppressLint("RememberReturnType")
@Composable
fun CustomRowTabBar(
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    pages : List<String>,
    textShadow: Shadow,
    fontFamily: FontFamily,
    fontSize : TextUnit,
    fontSelectColor : Color,
    fontUnSelectColor : Color,
    boxHeight : Dp
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .height(boxHeight),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        pages.forEachIndexed { index, title ->
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .wrapContentSize()
                    .clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                contentAlignment = Alignment.Center
            )
            {
                // 선택 텍스트
                if (index == pagerState.currentPage) {
                    CustomText(
                        title,
                        textShadow,
                        fontFamily,
                        fontSize,
                        fontSelectColor
                    )
                }
                // 비 선택 텍스트
                else{
                    CustomText(
                        title,
                        textShadow,
                        fontFamily,
                        fontSize,
                        fontUnSelectColor
                    )
                }
            }
        }
    }
}