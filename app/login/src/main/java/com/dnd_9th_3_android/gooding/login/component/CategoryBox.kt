package com.dnd_9th_3_android.gooding.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import com.dnd_9th_3_android.gooding.login.type.CategoryImageType

@Composable
fun CategoryBox(
    boxNum : Int,
    selected : Boolean
) {
    val modi = if (selected){
        Modifier
            .size(dimensionResource(id = R.dimen.size_100))
            .background(
                color = colorResource(id = R.color.blue_gray_6),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_10))
            )
            .border(
                border = BorderStroke(
                    width = dimensionResource(id = R.dimen.strock_1_5),
                    color = colorResource(id = R.color.secondary_1)
                )
            )
    }else{
        Modifier
            .size(dimensionResource(id = R.dimen.size_100))
            .background(
                color = colorResource(id = R.color.blue_gray_6),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_10))
            )
    }

    Column(
        modifier = modi,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_14)))

        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.size_50)),
            contentDescription = null,
            painter = painterResource(id = CategoryImageType.categoryImageList[boxNum]),
            
        )
        
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_5_37)))

        Text(text = CategoryImageType.categoryTextList[boxNum])
    }

}