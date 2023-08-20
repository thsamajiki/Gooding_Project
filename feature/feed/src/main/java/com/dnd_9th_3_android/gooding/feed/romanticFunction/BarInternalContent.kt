package com.dnd_9th_3_android.gooding.feed.romanticFunction

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.dnd_9th_3_android.gooding.core.data.R

// 백 그라운드 뷰
@Composable
fun BarInternalContent() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_24))
        ){
            Image(
                painter = painterResource(id = R.drawable.bar_start_image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )   
        }
        
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_20)))

        //bar
        Image(
            painter = painterResource(id = R.drawable.bar) ,
            contentDescription = null,
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.bar_w))
                .wrapContentHeight()
        )

        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_20)))

        Box(
            modifier = Modifier.size(dimensionResource(id = R.dimen.padding_24))
        ){
            Image(
                painter = painterResource(id = R.drawable.bar_end_image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}