package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.dnd_9th_3_android.gooding.feature.feed.R
@Composable
fun RomanticBarLayer(
    romanticPer : Int,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(
                top = 20.dp,
                start = 18.dp,
                end = 18.dp,
                bottom = 14.dp
            )
            .fillMaxWidth()
            .height(83.dp),
    ){
        Image(
            painter = painterResource(id = R.drawable.romantic_bar),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        )
    }
}