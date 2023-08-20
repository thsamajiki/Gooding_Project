package com.dnd_9th_3_android.gooding.feed.romanticFunction

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.dnd_9th_3_android.gooding.core.data.R

const val MAX_COLRINDEX = 12

@Composable
fun getRomanticColorList(
): List<Color> {
    return listOf(
        colorResource(id = R.color.state1),
        colorResource(id = R.color.state2),
        colorResource(id = R.color.state3),
        colorResource(id = R.color.state4),
        colorResource(id = R.color.state5),
        colorResource(id = R.color.state6),
        colorResource(id = R.color.state7),
        colorResource(id = R.color.state8),
        colorResource(id = R.color.state9),
        colorResource(id = R.color.state10),
        colorResource(id = R.color.state11),
        colorResource(id = R.color.state12)
    )
}