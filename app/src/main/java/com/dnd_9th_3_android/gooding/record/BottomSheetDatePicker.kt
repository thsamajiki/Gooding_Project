package com.dnd_9th_3_android.gooding.record

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.BottomSheetDatePickerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

class BottomSheetDatePicker : BottomSheetDialogFragment() {
    private var _binding: BottomSheetDatePickerBinding? = null
    private val binding: BottomSheetDatePickerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetDatePickerBinding.inflate(inflater, container, false)

        setupView()
        setupListeners()

        return binding.root
    }

    override fun getTheme(): Int = R.style.RounderBottomSheetDialog

    private fun setupView() {
        binding.cvDatePicker.background = GradientDrawable().apply {
            val radius = resources.getDimension(R.dimen.bottom_sheet_radius)
            cornerRadii = floatArrayOf(radius, radius, radius, radius, 0f, 0f, 0f, 0f)
        }
    }

    private fun setupListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.btnComplete.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val year = currentTime.get(Calendar.YEAR)
            val month = currentTime.get(Calendar.MONTH)
            val day = currentTime.get(Calendar.DAY_OF_MONTH)


            dismiss()
        }
    }

    companion object {
        fun newInstance(): BottomSheetDatePicker =
            BottomSheetDatePicker().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}