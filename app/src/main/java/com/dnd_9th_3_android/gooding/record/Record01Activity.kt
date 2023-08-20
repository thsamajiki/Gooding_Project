package com.dnd_9th_3_android.gooding.record

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.ActivityRecord01Binding

class Record01Activity : AppCompatActivity() {

    private lateinit var binding: ActivityRecord01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecord01Binding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.progressBar.progress = 33

        initListeners()
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
                    R.drawable.border_text_input_layout_unselected
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
                    R.drawable.border_text_input_layout_unselected
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