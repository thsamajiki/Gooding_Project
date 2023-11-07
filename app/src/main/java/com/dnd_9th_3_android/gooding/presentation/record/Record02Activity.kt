package com.dnd_9th_3_android.gooding.presentation.record

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.data.api.RecordFeedService
import com.dnd_9th_3_android.gooding.data.model.feed.UploadFeedData
import com.dnd_9th_3_android.gooding.data.model.search.RequestUploadFeed1
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord02Binding

import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class Record02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord02Binding
    private val viewModel by viewModels<Record02ViewModel>()

    @Inject
    lateinit var recordFeedService: RecordFeedService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord02Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initView()
        initViewModel()
        initListeners()
    }

    @SuppressLint("CheckResult")
    private fun initView() {
        val currentProgress = binding.progressBar.progress
        getInterval().subscribe {
            binding.progressBar.progress = currentProgress + it.toInt()
        }
    }

    private fun getInterval(): Observable<Long> =
        Observable.interval(1L, TimeUnit.MILLISECONDS).map { interval ->
            interval + 1
        }.take(333)

    class AnimateProgressBar(
        private var progressBar: ProgressBar,
        private var from: Float,
        private var to: Float
    ) : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            super.applyTransformation(interpolatedTime, t)
            val value = from + (to - from) * interpolatedTime
            progressBar.progress = value.toInt()
        }
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
//            val filePath = PathUtil.getPath(baseContext, uri) ?: return@setOnClickListener
//            val file = File(filePath)

            // 단일 파일일 때
//            val body = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
//            val thumbnailPart = MultipartBody.Part.createFormData("file", file.name, body)

//            lifecycleScope.launch {
//                recordFeedService.uploadFeed(
//                    thumbnail = thumbnailPart,
//                    oauthId = getTextRequestBody(),
//                    thumbnailDirectory = getTextRequestBody(),
//                    images =
//                )
//            }

            viewModel.uploadFeed()
        }

        /*
        val filePath = PathUtil.getPath(requireContext(), galleryUri) ?: return
        val file = File(filePath)

        val body = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("file", file.name, body)

        val parts = mutableListOf<MultipartBody.Part>()
           for (file in files) {
    val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
    val part = MultipartBody.Part.createFormData("file[]", file.name, requestFile)
    parts.add(part)
}
         */
    }

    // object
    private fun getRequestBody(uploadRequest: RequestUploadFeed1): RequestBody {
        return RequestBody.create("application/json".toMediaType(), Gson().toJson(uploadRequest))
    }

    // text : oauthId, thumbnailDirectory
    private fun getTextRequestBody(text: String): RequestBody {
        return RequestBody.create("text/plain".toMediaType(), text)
    }

    companion object {
        fun getIntent(context: Context,
//                      uploadFeedData: UploadFeedData
        ) =
            Intent(context, Record02Activity::class.java).apply {
//                putExtra(Record02ViewModel.KEY_UPLOAD_FEED_DATA,
//                    uploadFeedData
//                )
            }
    }
}