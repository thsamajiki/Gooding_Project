package com.dnd_9th_3_android.gooding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.dnd_9th_3_android.gooding.api.LoginRetrofitUtil
import com.dnd_9th_3_android.gooding.data.GoogleLoginInterface
import com.dnd_9th_3_android.gooding.data.KaKaoLoginInterface
import com.dnd_9th_3_android.gooding.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.kakao.sdk.auth.model.OAuthToken
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private var _binding : ActivityLoginBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var kaKaoLogin : KaKaoLoginInterface
    @Inject lateinit var googleLogin : GoogleLoginInterface
    // firebase
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var firebaseAuth: FirebaseAuth


    // kakao callback
    private val callback : (OAuthToken?,Throwable?) -> Unit = { token, error->
        kaKaoLogin.initCallback(error,token,this@LoginActivity, loginCallback = {
            if (it!=null){
                LoginRetrofitUtil.loginApiService.loginKaKao(it).enqueue(
                    object : Callback<String> {
                        override fun onResponse(
                            call: Call<String>,
                            response: Response<String>
                        ) {
                            if (response.isSuccessful){
                                Log.d("is sucess!",response.body().toString())
                            }else{
                                Log.d("error",response.errorBody().toString())
                            }
                        }

                        override fun onFailure(call: Call<String>, t: Throwable) {
                            Log.d("fail..","not info")
                        }

                    })
            }
        })
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityLoginBinding.inflate(this@LoginActivity.layoutInflater)
        setContentView(binding.root)

        // init firebase
        firebaseAuth = FirebaseAuth.getInstance()
        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(), ActivityResultCallback { result ->
                googleLogin.setLauncher(this@LoginActivity,result,firebaseAuth, loginCallback = {
                    Log.d("Login google access token :",it.toString())
                })
            })

        // kakao login button
        binding.kakaoLogin.setOnClickListener {
            if (!kaKaoLogin.checkLogin()){
                kaKaoLogin.kaKaoLogin(this@LoginActivity,callback, loginCallback = {
                    Log.d("Login kakao access token :",it.toString())
                    if (it!=null) {
                        LoginRetrofitUtil.loginApiService.loginKaKao(it).enqueue(
                            object : Callback<String> {
                                override fun onResponse(
                                    call: Call<String>,
                                    response: Response<String>
                                ) {
                                    if (response.isSuccessful){
                                        Log.d("is sucess!",response.body().toString())
                                    }else{
                                        Log.d("error",response.errorBody().toString())
                                    }
                                }

                                override fun onFailure(call: Call<String>, t: Throwable) {
                                    Log.d("fail..","not info")
                                }

                            })
                    }
                })
            }
        }

        // google login button
        binding.googleLogin.setOnClickListener {
            googleLogin.login(this@LoginActivity, getString(R.string.server_client_id), launcher)
        }
    }

}