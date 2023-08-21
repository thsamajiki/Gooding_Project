package com.dnd_9th_3_android.gooding.feed.romanticFunction

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.dnd_9th_3_android.gooding.core.data.R

@Composable
fun getRomanticGradientColor(
    start : Float,
    end : Float
): Brush {
    return Brush.horizontalGradient(
        start to colorResource(id = R.color.secondary_1),
        end to colorResource(id = R.color.for_grada_1)
    )
}

@Composable
fun getRomanticGradientColor2(): Brush {
    return Brush.horizontalGradient(
        listOf(
            colorResource(id = R.color.for_grada_1),
            colorResource(id = R.color.secondary_1)
        )
    )
}