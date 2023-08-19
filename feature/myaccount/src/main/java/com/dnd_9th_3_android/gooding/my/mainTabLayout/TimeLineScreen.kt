package com.dnd_9th_3_android.gooding.my.mainTabLayout

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.data.contentLayout.poppins
import com.dnd_9th_3_android.gooding.my.viewModel.TodayViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.dnd_9th_3_android.gooding.api.RetrofitUtil
import com.dnd_9th_3_android.gooding.data.SampleFeedData
import com.dnd_9th_3_android.gooding.model.feed.MyFeed
import com.dnd_9th_3_android.gooding.model.feed.MyFeedList
import com.dnd_9th_3_android.gooding.my.itemFeed.ItemMainFeedScreen
import com.dnd_9th_3_android.gooding.my.mainLayout.DefaultTimeLineScreen
import com.dnd_9th_3_android.gooding.my.selectMonth.SelectMonthBottomSheet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun TimeLineScreen(
    todayViewModel: TodayViewModel = hiltViewModel()
) {
    // curent month data
    val currentKey = todayViewModel.monthPicker.monthDataList[todayViewModel.monthPicker.currentPickIndex].keyDate
    // is delete view ?
    var  showDeleteView by remember {
        mutableStateOf(false)
    }
    // is monthPicker view?
    var showSelectView by remember {
        mutableStateOf(false)
    }
    // 오류 있음 수정 필ㅇ ㅛ
//    if (showDeleteView){
//        DeleteFeedBottomSheet(0,
//            onDelete = {
//                // delete feed/ //
//            },
//            onClose = {
//                // close view
//                showDeleteView = false
//            },
//        )
//    }
    if (showSelectView){
        SelectMonthBottomSheet(todayViewModel =todayViewModel,onClose = {
            todayViewModel.monthPicker.apply {
                if (!this.isChange){
                    this.resetData()
                }else{
                    this.isChange = false
                }
            }
            showSelectView = false
        })
    }
    // month picker view
    Column(
        // padding 적용 ! 모든 타임라인 18Dp
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_18))
    ) {
        // select month view
        Row(
            Modifier
                .clickable {
                    showSelectView = true
                }
                .wrapContentSize()
        ){
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.border_size)))
            Text(
                text = currentKey,
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
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_13)))
        if (currentKey == "2023.8") {
            // 8월 데이터
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                // 임시 데이터 받기 !
                RetrofitUtil.setUserToken("eyJhbGciOiJIUzM4NCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJST0xFX1VTRVIiLCJpYXQiOjE2OTI0MjczNDksImV4cCI6MTY5MjQyOTE0OX0.Wbbj6maj9AGNe4Kexs76shZiE3KNnwL9xYpJ0qw3TTi4T8p00IeZHxI_7Qsxk8Y5")
                RetrofitUtil.userApiService.getMyRecords(1)
                    .enqueue(object :Callback<Unit>{
                        override fun onResponse(
                            call: Call<Unit>,
                            response: Response<Unit>
                        ) {
                            if (response.isSuccessful){
                                val dataList = response.body()!!
                                Log.d("dataSEt",dataList.toString())
//                                items(dataList){ data->
//                                    ItemMainFeedScreen(feed = data, onDeleteView = {
//                                        showDeleteView = it
//                                    })
//                                }
                            }else{
                                Log.d("fail 22",response.errorBody()!!.string())
                                Log.d("fail 22",response.message()!!.toString())
                            }
                        }

                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Log.d("fail data","load fail $t")
                        }

                    })
            }
        } else {
            // no user record
            DefaultTimeLineScreen()
        }
    }
}