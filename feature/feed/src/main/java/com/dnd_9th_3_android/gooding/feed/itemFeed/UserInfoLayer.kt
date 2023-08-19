package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import coil.compose.rememberImagePainter
import com.dnd_9th_3_android.gooding.model.user.UserInfo
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
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.dnd_9th_3_android.gooding.data.transform.TimeDataChanger
import com.dnd_9th_3_android.gooding.core.data.R


@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserInfoLayer(userInfo: UserInfo) {
    val painter = rememberImagePainter(
        data = userInfo.profile,
        builder = {
            crossfade(true)
        }
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_9)))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(
            start =  dimensionResource(id = R.dimen.padding_18)
        )
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.size_26))
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_6)))

        Text(
            text = userInfo.name,
            style = TextStyle(
                color = Color.White,
                shadow = Shadow(
                    color = colorResource(id = R.color.tab_shadow),
                    blurRadius = 10f
                ),
                fontSize = dimensionResource(id = R.dimen.text_14_sp).value.sp,
                fontWeight = FontWeight.Bold
            )
        )

    }
}