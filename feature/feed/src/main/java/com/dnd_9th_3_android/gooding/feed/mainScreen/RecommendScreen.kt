package com.dnd_9th_3_android.gooding.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dnd_9th_3_android.gooding.data.preventScroll.disabledHorizontalPointerInputScrollPost
import com.dnd_9th_3_android.gooding.data.preventScroll.disabledHorizontalPointerInputScrollPrev

// 메인 피드  - 추천
@Composable
fun RecommendScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .disabledHorizontalPointerInputScrollPrev()
            .background(Color.Yellow)
    ) {

    }
}