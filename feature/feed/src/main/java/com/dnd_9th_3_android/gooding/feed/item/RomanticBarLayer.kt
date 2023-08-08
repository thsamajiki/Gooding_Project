package com.dnd_9th_3_android.gooding.feed.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RomanticBarLayer(
    romanticPer : Int,
) {
    Box(
       modifier = Modifier
           .padding(
               top = 20.dp,
               start = 18.dp,
               end = 18.dp,
               bottom =  14.dp
           )
           .background(Color.Black)
           .fillMaxWidth()
           .height(83.dp)
    )
}