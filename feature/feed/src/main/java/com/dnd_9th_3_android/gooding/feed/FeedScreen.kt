package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FeedScreen() {
    Box(
        contentAlignment = Alignment.Center
    ){
        Text(text = "main feed")
    }
}


@Preview
@Composable
fun PreviewFeed(){
    FeedScreen()
}