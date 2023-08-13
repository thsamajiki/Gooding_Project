package com.dnd_9th_3_android.gooding.my.tabLayout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.poppins
import com.dnd_9th_3_android.gooding.my.viewModel.TodayViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun TimeLineScreen(
    todayViewModel: TodayViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_20)))
        Row(
            Modifier.clickable {

            }
        ){
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_18)))
            Text(
                text = "${todayViewModel.currentYear}.${todayViewModel.currentMonth}",
                fontFamily = poppins,
                fontSize = dimensionResource(id = R.dimen.main_text_sp).value.sp,
                color = Color.White
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(dimensionResource(id = R.dimen.arrow_size))
            ){
                Image(
                    painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .width(IntrinsicSize.Max),
                    contentDescription = null
                )
            }
        }
    }
}