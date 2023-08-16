package com.dnd_9th_3_android.gooding.my.itemFeed

import android.media.ThumbnailUtils
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.data.video.CheckUrl
import com.dnd_9th_3_android.gooding.data.video.VideoThumbnailUtil
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendardBold

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CenterFeedLayout(
    location : String,
    imageList : List<String>,
) {
    // is video check
    val painter = if (CheckUrl.isVideo(imageList[0])) rememberImagePainter(
        data = SampleFeedData.sampleThumb[1],
        builder = { crossfade(true) }
    )
    else rememberImagePainter(
        data = imageList[0],
        builder = { crossfade(true) }
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
        Card(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.image_h))
                .width(dimensionResource(id = R.dimen.image_w)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_4)),
            backgroundColor = Color.Transparent

        ){
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_11)))
        // 이미지 여러장인 경우 이미지 테스트 등록
        if (imageList.size>1) {
            Text(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .wrapContentSize(),
                text = "+${imageList.size - 1}",
                color = colorResource(id = R.color.blue_gray_3),
                fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
                fontFamily = pretendardBold
            )
        }
    }
}