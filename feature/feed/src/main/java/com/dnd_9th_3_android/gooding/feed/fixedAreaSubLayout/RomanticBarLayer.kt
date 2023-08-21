package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.data.contentLayout.coustomShadow
import com.dnd_9th_3_android.gooding.feed.romanticFunction.BarInternalContent
import com.dnd_9th_3_android.gooding.feed.romanticFunction.ProgressGraphic
import com.dnd_9th_3_android.gooding.feed.romanticFunction.ProgressSlider

@Composable
fun RomanticBarLayer(
    romanticPer : Float,
) {
    // total 높이 : 85(70+15) 드래그 탑 아이콘 까지 고려
    Box(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.romantic_w))
            .height(dimensionResource(id = R.dimen.romantic_total_h))
    ){
        // custom box (배경)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.romantic_h))
                .align(Alignment.BottomCenter)
                .background(
                    color = colorResource(id = R.color.romantic_bar_color),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_16))
                )
                .blur(dimensionResource(id = R.dimen.size_60))
                .coustomShadow(
                    color = colorResource(id = R.color.shadow_color_romantic),
                    offsetY = dimensionResource(id = R.dimen.padding_4),
                    blurRadius = dimensionResource(id = R.dimen.size_30)
                )
        ){
            BarInternalContent() // 기본 배경
        }
        val currentValue = remember {
            mutableStateOf(romanticPer)
        }
        val currentOffset = remember {
            mutableStateOf(Offset(0f,0f))
        }
        // 내부 슬라이더
        Box(
            modifier = Modifier
                .padding(
                    start = dimensionResource(id = R.dimen.padding_53),
                    end = dimensionResource(id = R.dimen.padding_53),
                    top = dimensionResource(id = R.dimen.padding_46),
                    bottom = dimensionResource(id = R.dimen.padding_31)
                )
                .fillMaxSize()
                .height(dimensionResource(id = R.dimen.size_60))
        ){
            ProgressSlider(
                currentValue = currentValue.value,
                changeValue = { value, offset ->
                    currentValue.value = value
                    currentOffset.value = offset
                }
            )
        }

        ProgressGraphic(progress = currentValue.value, offset = currentOffset.value) //현재 상태

    }
}