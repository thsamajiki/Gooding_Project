package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.model.UserInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.dnd_9th_3_android.gooding.feature.feed.R


@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserInfoLayer(userInfo:UserInfo,uploadTime : String) {
    val painter = rememberImagePainter(
        data = userInfo.profile,
        builder = {
            crossfade(true)
        }
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(18.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.user_image_size))
                .clip(CircleShape)
                .border(1.dp, Color.White, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = userInfo.name,color = Color.White,)
            Text(text = uploadTime,color = Color.White,)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "+팔로우",
            color = Color.White,
            fontSize = 10.sp,
            modifier = Modifier
                .background(Color.Black, RoundedCornerShape(20.dp))
                .padding(
                    start = 10.dp,
                    end = 10.dp,
                    top = 5.dp,
                    bottom = 5.dp
                )
        )

    }
}