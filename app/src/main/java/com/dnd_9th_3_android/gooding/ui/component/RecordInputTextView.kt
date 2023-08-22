package com.dnd_9th_3_android.gooding.ui.component

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.dnd_9th_3_android.gooding.R
import com.dnd_9th_3_android.gooding.databinding.ViewRecordInputBinding
import com.dnd_9th_3_android.gooding.presentation.util.fromDpToPx

@SuppressLint("SetTextI18n")
class RecordInputTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewRecordInputBinding =
        ViewRecordInputBinding.inflate(LayoutInflater.from(context), this)

    private val defaultInputBackground = GradientDrawable().apply {
        setColor(ContextCompat.getColor(context, R.color.tertiaryColor))
        cornerRadius = 6f.fromDpToPx().toFloat()
    }

    init {
        binding.root.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )

        binding.inputContainer.background = defaultInputBackground

        binding.inputView.setOnFocusChangeListener { _, hasFocus ->
            binding.inputContainer.background = if (hasFocus) {
                defaultInputBackground.apply {
                    setStroke(
                        1.5f.fromDpToPx(),
                        ContextCompat.getColor(context, R.color.primaryColor)
                    )
                }
            } else {
                defaultInputBackground
            }
        }

        binding.inputView.doOnTextChanged { text, _, _, _ ->
            binding.textCount.text = "${text?.length ?: 0}/100"
            disableError()
        }
    }

    fun setText(text: String) {
        binding.inputView.setText(text)
    }

    fun setHint(textHint: String) {
        binding.inputView.hint = textHint
        binding.inputView.setHintTextColor(
            ContextCompat.getColor(
                context,
                R.color.quaternaryColor
            )
        )
    }


    fun setError(message: String) {
        binding.warning.isVisible = true
        binding.tvWarning.text = message

        binding.inputContainer.background = defaultInputBackground.apply {
            setStroke(1.5f.fromDpToPx(), ContextCompat.getColor(context, R.color.warning))
        }
    }

    fun disableError() {
        if (binding.warning.isGone) return

        binding.warning.isGone = true
        binding.tvWarning.text = ""

        binding.inputContainer.background = defaultInputBackground
    }

}