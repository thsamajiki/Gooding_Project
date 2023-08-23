package com.dnd_9th_3_android.gooding.login.viewModel

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.dnd_9th_3_android.gooding.api.RetrofitUtil
import com.dnd_9th_3_android.gooding.login.data.GoogleLoginInterface
import com.dnd_9th_3_android.gooding.login.data.KaKaoLoginInterface
import com.dnd_9th_3_android.gooding.model.user.AccessToken
import com.kakao.sdk.auth.model.OAuthToken
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){

}