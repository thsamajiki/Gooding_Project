package com.dnd_9th_3_android.gooding.my.selectMonth

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.feature.my.R
@Composable
fun ItemMonthData(
    year : Int,
    month : Int,
    isSelected : Boolean
) {
    val colorState =
        if (isSelected) {
            colorResource(id = R.color.secondary_1)
        }else{
            Color.White
        }

    Text(
        text = "$year.$month",
        color = colorState,
        modifier = Modifier.padding(
            top = dimensionResource(id = R.dimen.padding_8),
            bottom = dimensionResource(id = R.dimen.padding_8)
        )

    )
}