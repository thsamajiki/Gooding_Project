package com.dnd_9th_3_android.gooding.my.itemFeed

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendardBold

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CenterFeedLayout(
    location : String,
    imageList : List<String>,
) {
    val painter = rememberImagePainter(
        data = imageList[0],
        builder = {
            crossfade(true)
        }
    )
    // location
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.map_pin),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_12))
        )
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_4)))
        Text(
            text = location,
            color = colorResource(id = R.color.secondary_1),
            fontSize = dimensionResource(id = R.dimen.text_14_sp).value.sp,
            fontFamily = pretendardBold
        )
    }

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_12)))
    // center image
    Row(
        modifier = Modifier.wrapContentSize()
    ) {
        Image(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.image_h))
                .width(dimensionResource(id = R.dimen.image_w)),
            painter = painter,
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_11)))
        // 이미지 여러장인 경우 이미지 테스트 등록
        if (imageList.size>1) {
            Text(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .wrapContentSize(),
                text = "+${imageList.size - 1}"
            )
        }
    }
}