package com.dnd_9th_3_android.gooding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.dnd_9th_3_android.gooding.api.RetrofitUtil
import com.dnd_9th_3_android.gooding.data.GoogleLoginInterface
import com.dnd_9th_3_android.gooding.data.KaKaoLoginInterface
import com.dnd_9th_3_android.gooding.databinding.ActivityLoginBinding
import com.dnd_9th_3_android.gooding.model.AccessToken
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
                RetrofitUtil.LoginApiService.loginKaKao(it).enqueue(
                    object : Callback<AccessToken> {
                        override fun onResponse(
                            call: Call<AccessToken>,
                            response: Response<AccessToken>
                        ) {
                            if (response.isSuccessful){
                                Log.d("is sucess!",response.body()!!.accessToken)
                                loginUser(response.body()!!.accessToken)
                            }else{
                                Log.d("error",response.errorBody()?.string()!!)
                            }
                        }

                        override fun onFailure(call: Call<AccessToken>, t: Throwable) {
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
                    if (it!=null) {
                        RetrofitUtil.LoginApiService.loginGoogle(it).enqueue(
                            object : Callback<AccessToken>{
                                override fun onResponse(
                                    call: Call<AccessToken>,
                                    response: Response<AccessToken>
                                ) {
                                    if (response.isSuccessful){
                                        Log.d("is sucess!",response.body()!!.accessToken)
                                        loginUser(response.body()!!.accessToken)
                                    }else{
                                        Log.d("error",response.errorBody()?.string()!!)
                                    }
                                }

                                override fun onFailure(call: Call<AccessToken>, t: Throwable) {
                                    Log.d("fail..","not info")
                                }

                            }
                        )
                    }
                })
            })

        // kakao login button
        binding.kakaoLogin.setOnClickListener {
            if (!kaKaoLogin.checkLogin()){
                kaKaoLogin.kaKaoLogin(this@LoginActivity,callback, loginCallback = {
                    if (it==null){ //사용자 의도로 로그인 취소
                        /// do
                    }
                })
            }
        }

        // google login button
        binding.googleLogin.setOnClickListener {
            googleLogin.login(this@LoginActivity, getString(R.string.server_client_id), launcher)
        }
    }

    private fun loginUser(token:String){
        RetrofitUtil.setUserToken(token)
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }

}