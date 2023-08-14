package com.dnd_9th_3_android.gooding.my.contentLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R

@Composable
fun BoxText(
    borderColor: List<Color>,
    borderShape: Shape,
    borderBackground: Color,
    text: String,
    fontSize: TextUnit,
    fontColor: Color,
    hoPadding : Dp,
    verPadding : Dp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .border(
                width = dimensionResource(id = R.dimen.border_size),
                shape = borderShape,
                brush = Brush.linearGradient(
                    colors = borderColor,
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
            .background(
                shape = borderShape,
                color = borderBackground
            ),
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            color = fontColor,
            fontFamily = pretendard,
            modifier = Modifier
                .padding(
                    start = verPadding,
                    end = verPadding,
                    top = hoPadding,
                    bottom = hoPadding
                )
        )
    }

}