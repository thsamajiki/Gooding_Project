package com.dnd_9th_3_android.gooding.my.navi

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnd_9th_3_android.gooding.my.MyAccountScreen
import com.dnd_9th_3_android.gooding.my.mainLayout.MyScreen
import com.dnd_9th_3_android.gooding.my.mainLayout.SettingScreen


@Composable
fun NavigationGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = "myScreen"
    ){
        composable("myScreen"){ MyScreen(navController) }
        composable("settingScreen"){SettingScreen()}
    }
}