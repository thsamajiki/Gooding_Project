package com.dnd_9th_3_android.gooding.record

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.BottomSheetSelectCategoryBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetSelectCategory: BottomSheetDialogFragment() {
    private var _binding: BottomSheetSelectCategoryBinding? = null
    private val binding: BottomSheetSelectCategoryBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetSelectCategoryBinding.inflate(inflater, container, false)

        setupView()
        setupListeners()

        return binding.root
    }

    override fun getTheme(): Int = R.style.RounderBottomSheetDialog

    private fun setupView() {
        binding.cvSelectCategory.background = GradientDrawable().apply {
            val radius = resources.getDimension(R.dimen.bottom_sheet_radius)
            cornerRadii = floatArrayOf(radius, radius, radius, radius, 0f, 0f, 0f, 0f)
        }
    }

    private fun setupListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.btnComplete.setOnClickListener {

            dismiss()
        }
    }

    companion object {
        fun newInstance(): BottomSheetSelectCategory =
            BottomSheetSelectCategory().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}