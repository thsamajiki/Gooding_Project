package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.data.contentLayout.coustomShadow
import com.dnd_9th_3_android.gooding.data.video.CheckUrl

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RomanticBarLayer(
    romanticPer : Int,
) {
    // total 높이 : 329 드래그 탑 아이콘 까지 고려
    Box(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.romantic_w))
            .height(dimensionResource(id = R.dimen.romantic_total_h))
    ){
        // custom box
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

        }
    }
}