package com.dnd_9th_3_android.gooding.my.mainLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.BoxText
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendard

@Composable
fun DefaultTimeLineScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_18))
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_2)))
        Text(
            text = "이번달의 첫번째 굳이데이 기록을 남겨보세요.",
            fontSize = dimensionResource(id = R.dimen.text_14_sp).value.sp,
            fontFamily = pretendard,
            color = colorResource(id = R.color.blue_gray_3)
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_12)))
        //record button
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .border(
                    width = dimensionResource(id = R.dimen.border_size),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_6)),
                    color = colorResource(id = R.color.blue_gray_3)
                )
                .background(
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_6)),
                    color = Color.Transparent
                )
                .clickable {
                    // go record activity
                }
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = "기록하기",
                fontSize = dimensionResource(id = R.dimen.text_16_sp).value.sp,
                color = Color.White,
                fontFamily = pretendard,
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_11_5),
                        bottom = dimensionResource(id = R.dimen.padding_11_5)
                    )
            )
        }
    }
}