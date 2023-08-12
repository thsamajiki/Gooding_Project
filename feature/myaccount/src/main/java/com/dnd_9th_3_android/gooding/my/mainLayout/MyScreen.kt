package com.dnd_9th_3_android.gooding.my.mainLayout

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dnd_9th_3_android.gooding.data.SampleUserData
import com.dnd_9th_3_android.gooding.feature.my.R
import com.dnd_9th_3_android.gooding.my.subLayout.LevelScreen
import com.dnd_9th_3_android.gooding.my.subLayout.TopMenuScreen
import com.dnd_9th_3_android.gooding.my.subLayout.UserInfoScreen
import com.google.android.material.bottomnavigation.BottomNavigationView


@Composable
fun MyScreen(
    navController : NavController,
    bottomNavi : BottomNavigationView
) {
    val lazyState = rememberLazyListState()
    // y축 스크롤
    var scrolledY = 0f
    var previousOffset = 0
    LazyColumn(
        Modifier.fillMaxSize(),
        lazyState
    ) {
        item {
            Column(
                modifier = Modifier
                    .graphicsLayer {
                        scrolledY += lazyState.firstVisibleItemScrollOffset - previousOffset
                        translationY = scrolledY * 0.5f
                        previousOffset = lazyState.firstVisibleItemScrollOffset
                    }
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                // main content

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.top_margin)))
                TopMenuScreen(navController,bottomNavi)
                LevelScreen(painterResource(id = R.drawable.level_icon), "LV1.초보 낭만러")
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_28)))
                UserInfoScreen(userInfo = SampleUserData.sampleUserData[0])
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_24)))
            }
        }

    }


}


@Preview(showBackground = true)
@Composable
fun PreviewMyScreen(){
    MyScreen(rememberNavController(),BottomNavigationView(LocalContext.current))
}
