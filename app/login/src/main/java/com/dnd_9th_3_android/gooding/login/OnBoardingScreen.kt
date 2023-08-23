package com.dnd_9th_3_android.gooding.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.foundation.Image
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dnd_9th_3_android.gooding.data.customProgress.CustomProgressBar
import com.dnd_9th_3_android.gooding.login.navi.OnBoardingNaviGraph
import com.dnd_9th_3_android.gooding.login.viewModel.LoginViewModel
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.dnd_9th_3_android.gooding.login.component.BottomTextBox
import com.dnd_9th_3_android.gooding.login.type.BottomTextBoxType

@Composable
fun OnBoardingScreen(
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    var nextStepButtonType by remember{
        mutableStateOf(1)
    }
    Box() {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .align(Alignment.TopCenter)
        ) {
            // top box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.size_93))
            ) {
                // back button
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.padding_24))
                        .align(Alignment.BottomStart)
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_11),
                            bottom = dimensionResource(id = R.dimen.padding_14)
                        )
                        .clickable {
                            // pop back stack
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            CustomProgressBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.padding_4)),
                width = dimensionResource(id = R.dimen.full_w),
                backgroundColor = colorResource(id = R.color.blue_gray_5),
                foregroundColor = Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.secondary_1),
                        colorResource(id = R.color.secondary_1)
                    )
                ),
                percent = loginViewModel.progress,
                isShownText = false
            )

            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()
                OnBoardingNaviGraph(navController = navController)
            }
        }

        // 텍스트 버튼
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .padding(
                    start = dimensionResource(id = R.dimen.padding_18),
                    end = dimensionResource(id = R.dimen.padding_18),
                    bottom = dimensionResource(id = R.dimen.padding_28)
                )
        ) {
            BottomTextBoxType(nextStepButtonType)
        }
    }
}