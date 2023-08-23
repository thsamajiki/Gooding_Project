package com.dnd_9th_3_android.gooding.login.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.login.type.CategoryListType
import com.dnd_9th_3_android.gooding.model.user.Category

@Composable
fun CategoryBox(
    category : Category,
    clickData : ()->Unit
) {
    val backMode = if (category.selected){
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
            .clickable {
                clickData()
            }
    }else{
        Modifier
            .size(dimensionResource(id = R.dimen.size_100))
            .background(
                color = colorResource(id = R.color.blue_gray_6),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_10))
            )
            .clickable {
                clickData
            }
    }

    Column(
        modifier = backMode,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_14)))

        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.size_50)),
            contentDescription = null,
            painter = painterResource(id = category.imageResource),
            
        )
        
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_5_37)))

        Text(
            text = category.name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = dimensionResource(id = R.dimen.text_12).value.sp
        )
    }

}