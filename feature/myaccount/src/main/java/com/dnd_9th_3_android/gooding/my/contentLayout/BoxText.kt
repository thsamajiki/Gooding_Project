package com.dnd_9th_3_android.gooding.my.contentLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R

@Composable
fun BoxText(
    borderColor : Color,
    borderShape : Shape,
    borderBackground : Color,
    text : String,
    fontSize : TextUnit,
    fontColor : Color
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .border(
                width = dimensionResource(id = R.dimen.border_size),
                color = borderColor,
                shape = borderShape
            )
            .background(borderBackground)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_10),
                end = dimensionResource(id = R.dimen.padding_10),
                top = dimensionResource(id = R.dimen.padding_6),
                bottom = dimensionResource(id = R.dimen.padding_6)
            ),
            fontSize = fontSize,
            color = fontColor,
            fontWeight = FontWeight.Bold
        )
    }
}