package com.dnd_9th_3_android.gooding.my.subLayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.model.UserInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.my.contentLayout.BoxText

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserInfoScreen(
    userInfo : UserInfo
) {
    // image
    val painter = rememberImagePainter(
        data = userInfo.profile,
        builder = {
            crossfade(true)
        }
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.padding_20),
                end = dimensionResource(id = R.dimen.padding_20)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.profile_image_size))
                .clip(CircleShape)
                .border(dimensionResource(id = R.dimen.border_size), Color.White, CircleShape)
        )
        Spacer(modifier =Modifier.width(dimensionResource(id = R.dimen.padding_10)))
        Text(
            text =  userInfo.name,
            fontSize = dimensionResource(id = R.dimen.profile_name_text).value.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        BoxText(
            borderColor = colorResource(id = R.color.blue_gray),
            borderShape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_6)),
            borderBackground = colorResource(id = R.color.blue_gray),
            text = "프로필 수정",
            fontSize = dimensionResource(id = R.dimen.text_12).value.sp,
            fontColor = Color.White)
    }
}