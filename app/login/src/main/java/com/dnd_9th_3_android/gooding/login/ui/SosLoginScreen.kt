package com.dnd_9th_3_android.gooding.login.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.material.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//@Composable
//fun SosLoginScreen(
//    navController: NavHostController
//) {
//    Box(modifier = Modifier.fillMaxSize()) {
//        // 뒤로가기 제어
//        BackHandler(enabled = true, onBack = {})
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .wrapContentSize()
//                .padding(
//                    top = dimensionResource(id = R.dimen.padding_181),
//                    start = dimensionResource(id = R.dimen.padding_53_5)
//                )
//                .align(Alignment.TopCenter)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.gooding_splash_text),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(dimensionResource(id = R.dimen.size_135))
//                    .height(dimensionResource(id = R.dimen.size_37))
//            )
//
//            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_14)))
//
//            Text(
//                text = "굳잉과 함께 나만의 굳이데이 기록을 남겨보세요",
//                fontSize = dimensionResource(id = R.dimen.text_14_sp).value.sp,
//                color = colorResource(id = R.color.blue_gray_2),
//                fontWeight = FontWeight.Bold
//            )
//        }
//
//        Column(
//            modifier = Modifier
//                .wrapContentSize()
//                .align(Alignment.BottomCenter)
//                .padding(
//                    bottom = dimensionResource(id = R.dimen.padding_80),
//                    start = dimensionResource(id = R.dimen.padding_18),
//                    end = dimensionResource(id = R.dimen.padding_18)
//                )
//        ){
//            Image(
//                painter = painterResource(id = R.drawable.kakao_login_image),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(dimensionResource(id = R.dimen.size_324))
//                    .height(dimensionResource(id = R.dimen.size_47))
//                    .clickable {
//
//                    }
//            )
//            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_12)))
//            Image(
//                painter = painterResource(id = R.drawable.google),
//                contentDescription = null,
//                modifier = Modifier
//                    .width(dimensionResource(id = R.dimen.size_324))
//                    .height(dimensionResource(id = R.dimen.size_47))
//                    .clickable {
//
//                    }
//            )
//        }
//    }
//}