package com.dnd_9th_3_android.gooding.presentation.record

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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

        binding.btnComplete.background = ContextCompat.getDrawable(requireContext(), R.drawable.button_background01)
    }

    private fun setupListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.cvCategory01.setOnClickListener {
            binding.cvCategory01.strokeColor = ContextCompat.getColor(requireContext(), R.color.primaryColor)
        }

        binding.cvCategory02.setOnClickListener {
            binding.cvCategory01.strokeColor = ContextCompat.getColor(requireContext(), R.color.primaryColor)
        }

        binding.cvCategory03.setOnClickListener {

        }

        binding.cvCategory04.setOnClickListener {

        }

        binding.cvCategory05.setOnClickListener {

        }

        binding.cvCategory06.setOnClickListener {

        }

        binding.cvCategory07.setOnClickListener {

        }

        binding.cvCategory08.setOnClickListener {

        }

        binding.cvCategory09.setOnClickListener {

        }

        binding.cvCategory10.setOnClickListener {

        }

        binding.cvCategory11.setOnClickListener {

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