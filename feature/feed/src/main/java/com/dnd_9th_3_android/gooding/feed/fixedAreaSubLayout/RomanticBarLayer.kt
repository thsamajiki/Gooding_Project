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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.dnd_9th_3_android.gooding.core.data.R
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.data.video.CheckUrl

@OptIn(ExperimentalCoilApi::class)
@Composable
fun RomanticBarLayer(
    romanticPer : Int,
) {
    Image(
        modifier =Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.romantic_var),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}