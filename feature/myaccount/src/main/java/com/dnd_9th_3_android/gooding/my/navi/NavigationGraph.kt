package com.dnd_9th_3_android.gooding.my.navi

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnd_9th_3_android.gooding.my.mainLayout.MyScreen
import com.dnd_9th_3_android.gooding.my.mainLayout.SettingScreen
import com.google.android.material.bottomnavigation.BottomNavigationView


@Composable
fun NavigationGraph(
    navController: NavHostController,
    bottomNavi : BottomNavigationView
){
    NavHost(
        navController = navController,
        startDestination = "myScreen"
    ){
        composable("myScreen"){ MyScreen(navController,bottomNavi) }
        composable("settingScreen"){SettingScreen(navController,bottomNavi)}
    }
}