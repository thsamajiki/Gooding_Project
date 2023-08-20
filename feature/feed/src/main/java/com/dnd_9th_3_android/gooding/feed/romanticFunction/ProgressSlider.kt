package com.dnd_9th_3_android.gooding.feed.romanticFunction

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.smarttoolfactory.slider.ColorfulSlider
import com.smarttoolfactory.slider.MaterialSliderDefaults
import com.smarttoolfactory.slider.SliderBrushColor


// https://github.com/SmartToolFactory/Compose-Colorful-Sliders
@Composable
fun ProgressSlider(
    currentValue : Float,
    chageValue : (Float) -> Unit,
    colorList : List<Color>

) {

    ColorfulSlider(
        currentValue,
        onValueChange = { it->
            chageValue(it)
        },
        modifier = Modifier.fillMaxSize(),
        valueRange = 0f..100f,
        colors =   MaterialSliderDefaults.materialColors(
            inactiveTrackColor = SliderBrushColor(color = Color.Transparent),
            activeTrackColor = SliderBrushColor(
                brush = Brush.verticalGradient(colorList),
            )
        )

    )
}

