package com.dnd_9th_3_android.gooding.login.navi

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dnd_9th_3_android.gooding.login.ui.CheckCategoryScreen
import com.dnd_9th_3_android.gooding.login.ui.FinishScreen
import com.dnd_9th_3_android.gooding.login.ui.NickNameScreen
import com.dnd_9th_3_android.gooding.login.viewModel.LoginViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnBoardingNaviGraph(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = "nickNameScreen"
    ){
        composable("nickNameScreen"){
            NickNameScreen(navController)
            loginViewModel.progress = 33
        }
        composable("checkCategoryScreen"){
            CheckCategoryScreen(navController)
            loginViewModel.progress = 66
        }
        composable("finishScreen"){
            FinishScreen(navController)
            loginViewModel.progress = 100
        }
    }
}