package com.dnd_9th_3_android.gooding.record

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord02Binding
import kotlinx.coroutines.launch

class Record02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord02Binding
    private val viewModel by viewModels<Record02ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord02Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initView()
        initViewModel()
        initListeners()
    }

    private fun initView() {
        binding.progressBar.setProgressCompat(66, true)
    }

    private fun initViewModel() {
        with(viewModel) {
            lifecycleScope.launch {
                uiState.collect { state ->
                    when(state) {
                        is Record02ViewModel.UiState.UploadFeedFailed -> {
                            Toast.makeText(
                                this@Record02Activity,
                                "피드 업로드에 실패했습니다.",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                        is Record02ViewModel.UiState.UploadFeedSuccess -> {
                            // TODO: 피드 업로드에 성공하면 어느 페이지로 이동하기
                        }
                        is Record02ViewModel.UiState.Idle -> {}
                    }
                }
            }
        }
    }

    private fun initListeners() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }

        binding.cvRomanceLevel01.setOnClickListener {
            if (binding.cvRomanceLevel01.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )) {
                binding.cvRomanceLevel01.strokeColor = ContextCompat.getColor(this,
                    R.color.primaryColor
                )
            } else if (
                binding.cvRomanceLevel02.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                ) &&
                binding.cvRomanceLevel03.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                ) &&
                binding.cvRomanceLevel04.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                ) &&
                binding.cvRomanceLevel05.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            ) {
                binding.cvRomanceLevel01.strokeColor = ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            }
        }

        binding.cvRomanceLevel02.setOnClickListener {
            if (binding.cvRomanceLevel02.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )) {
                binding.cvRomanceLevel02.strokeColor = ContextCompat.getColor(this,
                    R.color.primaryColor
                )
            } else {
                binding.cvRomanceLevel02.strokeColor = ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            }
        }

        binding.cvRomanceLevel03.setOnClickListener {
            if (binding.cvRomanceLevel03.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )) {
                binding.cvRomanceLevel03.strokeColor = ContextCompat.getColor(this,
                    R.color.primaryColor
                )
            } else {
                binding.cvRomanceLevel03.strokeColor = ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            }
        }

        binding.cvRomanceLevel04.setOnClickListener {
            if (binding.cvRomanceLevel04.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )) {
                binding.cvRomanceLevel04.strokeColor = ContextCompat.getColor(this,
                    R.color.primaryColor
                )
            } else {
                binding.cvRomanceLevel04.strokeColor = ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            }
        }

        binding.cvRomanceLevel05.setOnClickListener {
            if (binding.cvRomanceLevel05.strokeColor == ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )) {
                binding.cvRomanceLevel05.strokeColor = ContextCompat.getColor(this,
                    R.color.primaryColor
                )
            } else {
                binding.cvRomanceLevel05.strokeColor = ContextCompat.getColor(this,
                    R.color.tertiaryColor
                )
            }
        }

        binding.btnFinishRecord.setOnClickListener {
            viewModel.uploadFeed()
        }
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, Record02Activity::class.java)
    }
}