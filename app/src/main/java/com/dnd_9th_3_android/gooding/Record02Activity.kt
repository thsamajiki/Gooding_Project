package com.dnd_9th_3_android.gooding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord02Binding

class Record02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord02Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initListeners()
    }

    private fun initListeners() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }

        binding.btnFinishRecord.setOnClickListener {

        }
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, Record02Activity::class.java)
    }
}