package com.dnd_9th_3_android.gooding

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dnd_9th_3_android.gooding.data.KaKaoLoginImpl
import com.dnd_9th_3_android.gooding.data.KaKaoLoginInterface
import com.dnd_9th_3_android.gooding.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private var _binding : ActivityLoginBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var kaKaoLogin : KaKaoLoginInterface

    private val callback : (OAuthToken?,Throwable?) -> Unit = { token, error->
        if (error != null){
            kaKaoLogin.toastMessage(this@LoginActivity,"카카오 계정 로그인 실패 $error")
        }else if (token != null){
            kaKaoLogin.toastMessage(this@LoginActivity,"카카오 계정 로그인 성공 $error")
            Log.d("token",token.toString())
            kaKaoLogin.getUserInfo(this@LoginActivity, loginCallback = {
                Log.d("Login! user info ",it)
            })
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityLoginBinding.inflate(this@LoginActivity.layoutInflater)
        setContentView(binding.root)
        // 모듈 + 카카오 해쉬 키 발급
        Log.d("모듈 연동 테스트","메인 -> 로그인 모듈 완료")
        Log.d(TAG, "keyhash : ${Utility.getKeyHash(this)}")

        // kakao login button
        binding.kakaoLogin.setOnClickListener {
            if (!kaKaoLogin.checkLogin()){
                kaKaoLogin.kaKaoLogin(this@LoginActivity,callback, loginCallback = {
                    Log.d("Login! ",it)
                })
            }
        }
    }
}