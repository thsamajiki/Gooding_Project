package com.dnd_9th_3_android.gooding.feed.romanticFunction

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette

import com.smarttoolfactory.slider.*
import com.dnd_9th_3_android.gooding.core.data.R

// https://github.com/SmartToolFactory/Compose-Colorful-Sliders
@Composable
fun ProgressSlider(
    currentValue : Float,
    changeValue : (
        value : Float,
        offset : Offset,
    ) -> Unit,
) {
//    val colorList = getRomanticGradientColor()
//    val data by remember {
//        mutableStateOf(Brush.horizontalGradient(colorList,currentValue))
//    }
    ColorfulIconSlider(
        value = currentValue,
        onValueChange = { value, Offset->
            changeValue(value,Offset)
            Log.d("value,off",value.toString()+","+Offset.toString())
        },
        modifier = Modifier.background(Color.Transparent),
        valueRange = 0f..100f,
        trackHeight = dimensionResource(id = R.dimen.padding_8),
        colors =   MaterialSliderDefaults.materialColors(
            activeTrackColor = SliderBrushColor(
                brush = getRomanticGradientColor2()
            ),
        ),
    ){
        Text(
            text = "",
            modifier = Modifier
                .background(Color.Transparent)
                .size(30.dp),
        )
    }
}

