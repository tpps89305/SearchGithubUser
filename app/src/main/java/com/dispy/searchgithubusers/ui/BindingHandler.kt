package com.dispy.searchgithubusers.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingHandler {

    @BindingAdapter("load")
    @JvmStatic
    fun bindImage(imageView: ImageView, url: String?) {
        imageView.load(url)
    }
}