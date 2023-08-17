package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

import com.dnd_9th_3_android.gooding.core.data.R
@Composable
fun RomanticBarLayer(
    romanticPer : Int,
) {
    Box(
        modifier = Modifier
            .padding(
                bottom = dimensionResource(id = R.dimen.padding_24)
            )
            .background(Color.Yellow)
            .width(324.dp)
            .height(70.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.romantic_bar),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}