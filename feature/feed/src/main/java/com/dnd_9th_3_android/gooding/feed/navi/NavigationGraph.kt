package com.dnd_9th_3_android.gooding.feed.navi

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnd_9th_3_android.gooding.feed.NowScreen
import com.dnd_9th_3_android.gooding.feed.RecommendScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    naviController: NavHostController
) {
    NavHost(
        navController = naviController,
        startDestination = "now"
    ){
        composable("now"){ NowScreen()}
        composable("hot"){ RecommendScreen() }
    }
}