package com.dnd_9th_3_android.gooding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // main에서 로그인 모듈의 액티비티로 이동
        Log.d("모듈 연동 테스트","메인 -> 로그인 모듈 시도")
        val intent = Intent(this@MainActivity,LoginActivity::class.java)
        startActivity(intent)
    }
}