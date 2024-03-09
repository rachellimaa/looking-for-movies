package com.rachellima.uicomponents

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import com.rachellima.uicomponents.databinding.CustomHeaderBinding

private const val IMAGE_DEFAULT = 0
class CustomHeader(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding = CustomHeaderBinding.inflate(LayoutInflater.from(context), this)
    private var headerSrc = 0
    init {
        parseAttrs(context, attrs)
    }

    private fun parseAttrs(context: Context, attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.CustomHeader) {
            headerSrc = getResourceId(R.styleable.CustomHeader_header_src, IMAGE_DEFAULT)
            val headerTitle = getString(R.styleable.CustomHeader_header_title).orEmpty()
            setTitle(headerTitle)
            setImageDefault()
        }
    }

    fun setImageDefault() {
        binding.customImageHeader.setImageResource(
            if (headerSrc != IMAGE_DEFAULT) headerSrc else R.drawable.ic_action_laugh
        )
    }

    fun setTitle(text: String) {
        binding.titleHeader.text = text
    }

    fun setTitle(@StringRes text: Int) {
        binding.titleHeader.setText(text)
    }
}