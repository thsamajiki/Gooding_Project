package com.dnd_9th_3_android.gooding.login.navi

import android.util.Log
import android.view.View
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnd_9th_3_android.gooding.login.LoginScreen
import com.dnd_9th_3_android.gooding.login.SplashScreen
import com.dnd_9th_3_android.gooding.login.ui.SosLoginScreen
import com.google.android.material.bottomnavigation.BottomNavigationView


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = "splashScreen"
    ){
        composable("splashScreen"){ SplashScreen() }
        composable("sosScreen"){ SosLoginScreen() }
    }
}