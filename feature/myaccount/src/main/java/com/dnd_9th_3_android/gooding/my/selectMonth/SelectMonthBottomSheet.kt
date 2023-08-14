package com.dnd_9th_3_android.gooding.my.selectMonth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.contentLayout.pretendard
import com.holix.android.bottomsheetdialog.compose.BottomSheetDialog
import com.holix.android.bottomsheetdialog.compose.BottomSheetDialogProperties
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dnd_9th_3_android.gooding.my.viewModel.TodayViewModel

@Composable
fun SelectMonthBottomSheet(
    todayViewModel : TodayViewModel,
    onClose : () -> Unit
) {
    BottomSheetDialog(
        onDismissRequest = {

        },
        properties = BottomSheetDialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ){
        Column(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.blue_gray_6),
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_24)),
                )
                .padding(dimensionResource(id = R.dimen.padding_18))
                .wrapContentHeight()
                .fillMaxWidth()
        ){
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_18)))

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "월 선택하기",
                    color = Color.White,
                    fontFamily = pretendard,
                    fontSize = dimensionResource(id = R.dimen.text_16_sp).value.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_6))
                        .clickable {
                            onClose()
                        }
                ){
                    Image(
                        painter = painterResource(id = R.drawable.baseline_close_24),
                        contentDescription = null,
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_18)))

            LazyColumn(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.size_144))
            ){
                var year = todayViewModel.todayYear
                var month = todayViewModel.todayMonth
                items(100){
                    // 현재선택 달 == 현재 뷰인 경우
                    val isSelected = todayViewModel.currentYear == year && todayViewModel.currentMonth==month
                    ItemMonthData(
                        year = year,
                        month = month,
                        isSelected = isSelected
                    )
                    if (month == 1){
                        year -= 1
                        month = 12
                    }else{
                        month -=1
                    }
                }
            }
        }
    }
}
