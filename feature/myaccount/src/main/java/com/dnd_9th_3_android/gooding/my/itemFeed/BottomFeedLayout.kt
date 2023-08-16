package com.dnd_9th_3_android.gooding.my.itemFeed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendardBold
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendardRegular
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BottomFeedLayout(
    subject : String,
    content : String,
    onMoreInfo : () -> Unit
) {
    Text(
        text = subject,
        fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
        fontFamily = pretendardBold,
        color = Color.White,
        modifier = Modifier
            .wrapContentHeight()
            .width(dimensionResource(id = R.dimen.text_w_content))
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_4)))
    Text(
        text = content,
        fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
        fontFamily = pretendardRegular,
        color = Color.White,
        maxLines = 2,
        modifier = Modifier
            .wrapContentHeight()
            .width(dimensionResource(id = R.dimen.text_w_content)),
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_12)))

    Row(
        modifier = Modifier
            .wrapContentSize()
            .clickable {
                onMoreInfo()
                // go detail
            }
    ){
        Text(
            text = "더보기",
            fontFamily = pretendardBold,
            fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
            color = colorResource(id = R.color.blue_gray_3)
        )
        Image(
            painter = painterResource(id = R.drawable.left_side_mini),
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_18))
        )
    }
}