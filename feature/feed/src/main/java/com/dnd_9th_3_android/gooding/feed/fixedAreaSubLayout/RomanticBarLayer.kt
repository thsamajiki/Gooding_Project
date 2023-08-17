package com.dnd_9th_3_android.gooding.feed.itemFeed

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
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

                start = 18.dp,
                end = dimensionResource(id = R.dimen.padding_18),
                bottom = dimensionResource(id = R.dimen.padding_24)
            )
            .fillMaxWidth()
            .height(83.dp),
    ){
        Image(
            painter = painterResource(id = R.drawable.romantic_bar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
    }
}