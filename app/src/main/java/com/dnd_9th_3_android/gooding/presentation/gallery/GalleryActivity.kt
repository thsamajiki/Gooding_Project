package com.dnd_9th_3_android.gooding.presentation.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.FeedFragment
import com.dnd_9th_3_android.gooding.MyGoodingFragment
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.presentation.record.Record01Activity
import com.dnd_9th_3_android.gooding.data.model.gallery.GalleryImageData
import com.dnd_9th_3_android.gooding.databinding.ActivityGalleryBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding

    private lateinit var galleryImageListAdapter: GalleryImageListAdapter

    private val viewModel by viewModels<GalleryViewModel>()

    private var currentOpenedFragment: String = FEED_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery)
//        binding = ActivityGalleryBinding.inflate(layoutInflater)
//        val view = binding.root
//
//        setContentView(view)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initView()
        initViewModel()
        initListeners()

        if (savedInstanceState != null) {
            currentOpenedFragment = savedInstanceState.getString(LAST_OPENED_FRAGMENT_REF).toString()
        }
    }

    private fun initView() {
        viewModel.getGalleryImages()
        initRecyclerView(binding.rvGalleryImage)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        galleryImageListAdapter = GalleryImageListAdapter(
            onClick = ::onClickGalleryImageItem
        )

        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return 1 // 1개의 인덱스가 가질 부피
                    }
                }
            }
            adapter = galleryImageListAdapter
        }
    }

    private fun onClickGalleryImageItem(galleryImageData: GalleryImageData) {

    }

    private fun initViewModel() {
        with(viewModel) {
            lifecycleScope.launch {
                uiState.collect { state ->
                    when(state) {
                        is GalleryViewModel.UiState.GetGalleryImageListSuccess -> {
                            galleryImageListAdapter.submitData(imageList.value!!)
                            Log.d("Success", "initViewModel: ${imageList.value}")
                        }
                        is GalleryViewModel.UiState.GetGalleryImageListFailed -> {
                            Toast.makeText(this@GalleryActivity, "이미지 목록을 불러오는 데 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }
                        is GalleryViewModel.UiState.Idle -> {}
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(LAST_OPENED_FRAGMENT_REF, currentOpenedFragment);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun initListeners() {
        binding.ivArrowBack.setOnClickListener {
            finish()

            val prevFragment = supportFragmentManager.fragments.find {
                it.isVisible
            }
//            supportFragmentManager.popBackStack(null, 0)
//            supportFragmentManager.beginTransaction().replace(R.id.fcv_main, prevFragment!!).commit()
        }

        binding.ivArrowDown.setOnClickListener {

        }

        binding.tvNextStep.setOnClickListener {
            val intent = Record01Activity.getIntent(this@GalleryActivity)
            startActivity(intent)
        }
    }

    private fun initFragmentType(type: String): Fragment {
        return when (type) {
            FEED_FRAGMENT -> {
                FeedFragment.newInstance()
            }

            MY_GOODING_FRAGMENT -> {
                MyGoodingFragment.newInstance()
            }

            else -> {
                throw IllegalArgumentException("There is no type: $type");
            }
        }
    }

    companion object {
        const val LAST_OPENED_FRAGMENT_REF = "LAST_OPENED_FRAGMENT_REF"
        const val FEED_FRAGMENT = "FEED_FRAGMENT"
        const val MY_GOODING_FRAGMENT = "MY_GOODING_FRAGMENT"

        fun getIntent(context: Context) =
            Intent(context, GalleryActivity::class.java)
    }
}