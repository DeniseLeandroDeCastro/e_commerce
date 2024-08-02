package com.denise.castro.e_commerce.util.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.denise.castro.e_commerce.R
import com.denise.castro.e_commerce.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var loadingTitle: String? = null

    private val binding = ProgressButtonBinding.inflate(LayoutInflater.from(context), this, true)

    private var state: ProgressButtonState = ProgressButtonState.Normal
        set(value) {
            field = value
            refreshState()
        }

    init {
        setLayout(attrs)
        refreshState()
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )

            setBackgroundResource(R.drawable.progress_button_background)

            val titleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_title, 0)
            if (titleResId != 0) {
                title = context.getString(titleResId)
            }

            val loadingTitleResId = attributes.getResourceId(R.styleable.ProgressButton_progress_button_loading_title, 0)
            if (loadingTitleResId != 0) {
                loadingTitle = context.getString(loadingTitleResId)
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {
        isEnabled = state.isEnabled
        isClickable = state.isEnabled
        refreshDrawableState()

        binding.textTitle.run {
            isEnabled = state.isEnabled
            isClickable = state.isEnabled
        }

        binding.progressButton.visibility = state.progressVisibility
        when (state) {
            ProgressButtonState.Normal -> binding.textTitle.text = title
            ProgressButtonState.Loading -> binding.textTitle.text = loadingTitle
        }
    }

    fun setNormal() {
        state = ProgressButtonState.Normal
    }

    fun setLoading() {
        state = ProgressButtonState.Loading
    }
}