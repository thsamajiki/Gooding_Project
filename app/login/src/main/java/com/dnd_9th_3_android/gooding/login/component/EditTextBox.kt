package com.dnd_9th_3_android.gooding.login.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.data.contentLayout.pretendardRegular
import androidx.compose.material.Text
//@Composable
//fun EditTextBox(
//    text : TextFieldValue,
//    possibleText : Boolean,
//    hintText: String,
//    onTexting : (TextFieldValue)-> Unit
//) {
//
//    // Composable icon 생성 -> 입력 삭제 버튼
//    val trailingIconView = @Composable {
//        IconButton(
//            onClick = {
//                // text 삭제
//                onTexting(TextFieldValue(""))
//            }
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(dimensionResource(id = R.dimen.padding_24))
//                    .padding(
//                        top = dimensionResource(id = R.dimen.padding_16),
//                        bottom = dimensionResource(id = R.dimen.padding_16),
//                        end = dimensionResource(id = R.dimen.padding_14)
//                    )
//            ){
//                Icon(
//                    painter = painterResource(id = R.drawable.close_button_nickname),
//                    contentDescription = "",
//                    Modifier.fillMaxSize()
//                )
//            }
//        }
//    }
//
//    Surface( // 배경
//        modifier = Modifier
//            .padding(
//                start = dimensionResource(id = R.dimen.padding_18),
//                end = dimensionResource(id = R.dimen.padding_18),
//            ),
//        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_6)),
//        // 배경 칼라 적용
//        border = if (text.text.isNotEmpty() && possibleText)
//            BorderStroke(
//            dimensionResource(id = R.dimen.padding_1_5),
//            colorResource(id = R.color.secondary_1)
//        ) else if (text.text.isNotEmpty() && !possibleText)
//            BorderStroke(
//                dimensionResource(id = R.dimen.padding_1_5),
//                colorResource(id = R.color.warn_color)
//            )
//        else null
//        , color = colorResource(id = R.color.blue_gray_6)
//    ) {
//        TextField(
//            value = text,
//            onValueChange = {newText ->
//                onTexting(newText)
//            }, //값 변경 시 동작
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(dimensionResource(id = R.dimen.padding_48)),
//            colors = TextFieldDefaults.textFieldColors(backgroundColor = colorResource(id = R.color.blue_gray_6)),
//            placeholder = {
//                Text(
//                    text = hintText,
//                    color = Color.White,
//                    fontSize = dimensionResource(id = R.dimen.text_14_sp).value.sp,
//                    fontFamily = pretendardRegular
//                )
//            }, //힌트 (텍스트 ,칼라 적용 )
//            trailingIcon = if (text.text.isNotEmpty()) trailingIconView else null,
//        )
//    }
//
//}
