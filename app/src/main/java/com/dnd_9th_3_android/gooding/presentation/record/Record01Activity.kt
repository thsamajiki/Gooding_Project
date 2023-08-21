package com.dnd_9th_3_android.gooding.presentation.record

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord01Binding
import com.dnd_9th_3_android.gooding.presentation.gallery.GalleryFileUiData
import com.dnd_9th_3_android.gooding.presentation.record.search.SearchGoodieDayPlaceActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Record01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord01Binding
    private lateinit var recordImageVideoListAdapter: RecordImageVideoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord01Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initView()
        initListeners()
    }

    private fun initView() {
        binding.progressBar.progress = 333

        initRecyclerView(binding.rvImageVideoFileList)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recordImageVideoListAdapter = RecordImageVideoListAdapter(
            onClick = ::onClickImageVideoItem
        )

        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = recordImageVideoListAdapter
            recordImageVideoListAdapter.submitList(
                listOf(
                    GalleryFileUiData(
                        0,
                        false,
                        1,
                        1,
                        "https://images.pexels.com/photos/1266810/pexels-photo-1266810.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                        0
                    ),
                    GalleryFileUiData(
                        1,
                        false,
                        2,
                        1,
                        "https://i.pinimg.com/236x/30/cd/c3/30cdc33a575df498cd4ed07d425e678f.jpg",
                        0
                    ),
                    GalleryFileUiData(
                        2,
                        false,
                        3,
                        1,
                        "https://images.unsplash.com/photo-1592743263126-bb241ee76ac7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8YmVhdXRpZnVsJTIwc2NlbmVyeXxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
                        0
                    ),
                    GalleryFileUiData(
                        3,
                        false,
                        4,
                        1,
                        "https://i.pinimg.com/236x/69/10/2e/69102e78da529ea20d00e10cdf308b7d--wanderlust-outdoors.jpg",
                        0
                    ),
                    GalleryFileUiData(
                        4,
                        false,
                        5,
                        1,
                        "https://w0.peakpx.com/wallpaper/1014/964/HD-wallpaper-nature-autumn-beautiful-beauty-scenery-landscapes-forest-red-fall.jpg",
                        0
                    )
                )
            )
        }
    }

    private fun onClickImageVideoItem(galleryFileUiData: GalleryFileUiData) {
        TODO("Not yet implemented")
    }

    private fun initListeners() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }

        binding.layoutEditGoodieDay.setOnClickListener {
            closeKeyboard(binding.root)

            if (binding.textEditTitleGoodieDay.hasFocus()) {
                binding.textEditTitleGoodieDay.clearFocus()
            }

            if (binding.textEditContentGoodieDay.hasFocus()) {
                binding.textEditContentGoodieDay.clearFocus()
            }
        }

        binding.textEditTitleGoodieDay.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.textEditTitleGoodieDay.hint = ""
                binding.textLayoutTitleGoodieDay.background = ContextCompat.getDrawable(this,
                    R.drawable.border_text_input_layout_selected
                )
            } else {
                binding.textEditTitleGoodieDay.setHint(R.string.please_write_title)
                binding.textLayoutTitleGoodieDay.background = ContextCompat.getDrawable(this,
                    R.drawable.border_text_input_layout_unselected_with_padding
                )
            }
        }

        binding.textEditContentGoodieDay.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.textEditContentGoodieDay.hint = ""
                binding.textLayoutContentGoodieDay.background = ContextCompat.getDrawable(this,
                    R.drawable.border_text_input_layout_selected
                )
            } else {
                binding.textEditContentGoodieDay.setHint(R.string.please_write_your_goodie_day)
                binding.textLayoutContentGoodieDay.background = ContextCompat.getDrawable(this,
                    R.drawable.border_text_input_layout_unselected_with_padding
                )
            }
        }

        binding.textLayoutDateGoodieDay.setOnClickListener {
            val bottomSheetDatePicker = BottomSheetDatePicker.newInstance()
            bottomSheetDatePicker.show(supportFragmentManager, bottomSheetDatePicker.tag)
        }

        binding.cvPlaceGoodieDay.setOnClickListener {
            val intent = SearchGoodieDayPlaceActivity.getIntent(this@Record01Activity)
            startActivity(intent)
        }

        binding.cvCategoryGoodieDay.setOnClickListener {
            val bottomSheetSelectCategory = BottomSheetSelectCategory.newInstance()
            bottomSheetSelectCategory.show(supportFragmentManager, bottomSheetSelectCategory.tag)
        }

        binding.switchPrivacySetting.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {

            } else {

            }
        }

        binding.btnNextStep.setOnClickListener {
            val intent = Record02Activity.getIntent(this@Record01Activity)
            startActivity(intent)
        }
    }

    private fun closeKeyboard(view: View) {
        val imm = view.context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        fun getIntent(context: Context) =
            Intent(context, Record01Activity::class.java)
    }
}