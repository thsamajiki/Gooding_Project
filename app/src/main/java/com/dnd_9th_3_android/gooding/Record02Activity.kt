package com.dnd_9th_3_android.gooding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord02Binding
import com.google.android.material.progressindicator.BaseProgressIndicator

class Record02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord02Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initView()

        initListeners()
    }

    private fun initView() {
        binding.progressBar.setProgressCompat(66, true)
    }

    private fun initListeners() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }

        binding.cvRomanceLevel01.setOnClickListener {
            if (binding.cvRomanceLevel01.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)) {
                binding.cvRomanceLevel01.strokeColor = ContextCompat.getColor(this, R.color.primaryColor)
            } else if (
                binding.cvRomanceLevel02.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor) &&
                binding.cvRomanceLevel03.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor) &&
                binding.cvRomanceLevel04.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor) &&
                binding.cvRomanceLevel05.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)
            ) {
                binding.cvRomanceLevel01.strokeColor = ContextCompat.getColor(this, R.color.tertiaryColor)
            }
        }

        binding.cvRomanceLevel02.setOnClickListener {
            if (binding.cvRomanceLevel02.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)) {
                binding.cvRomanceLevel02.strokeColor = ContextCompat.getColor(this, R.color.primaryColor)
            } else {
                binding.cvRomanceLevel02.strokeColor = ContextCompat.getColor(this, R.color.tertiaryColor)
            }
        }

        binding.cvRomanceLevel03.setOnClickListener {
            if (binding.cvRomanceLevel03.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)) {
                binding.cvRomanceLevel03.strokeColor = ContextCompat.getColor(this, R.color.primaryColor)
            } else {
                binding.cvRomanceLevel03.strokeColor = ContextCompat.getColor(this, R.color.tertiaryColor)
            }
        }

        binding.cvRomanceLevel04.setOnClickListener {
            if (binding.cvRomanceLevel04.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)) {
                binding.cvRomanceLevel04.strokeColor = ContextCompat.getColor(this, R.color.primaryColor)
            } else {
                binding.cvRomanceLevel04.strokeColor = ContextCompat.getColor(this, R.color.tertiaryColor)
            }
        }

        binding.cvRomanceLevel05.setOnClickListener {
            if (binding.cvRomanceLevel05.strokeColor == ContextCompat.getColor(this, R.color.tertiaryColor)) {
                binding.cvRomanceLevel05.strokeColor = ContextCompat.getColor(this, R.color.primaryColor)
            } else {
                binding.cvRomanceLevel05.strokeColor = ContextCompat.getColor(this, R.color.tertiaryColor)
            }
        }

        binding.btnFinishRecord.setOnClickListener {

        }
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, Record02Activity::class.java)
    }
}