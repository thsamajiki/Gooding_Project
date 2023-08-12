package com.dnd_9th_3_android.gooding.my.subLayout

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dnd_9th_3_android.gooding.feature.my.R
import com.google.android.material.bottomnavigation.BottomNavigationView


@SuppressLint("RestrictedApi")
@Composable
fun TopMenuScreen(
    navController: NavController,
    bottomNavi : BottomNavigationView
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.top_size)),
    ){
        Text(
            text = "마이 굳잉",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = dimensionResource(R.dimen.main_text_sp).value.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = dimensionResource(id = R.dimen.padding_16))
                .size(dimensionResource(id = R.dimen.icon_size))
                .clickable {
                    navController.navigate("settingScreen")
                    bottomNavi.visibility = View.GONE
                }
        )

    }
}
