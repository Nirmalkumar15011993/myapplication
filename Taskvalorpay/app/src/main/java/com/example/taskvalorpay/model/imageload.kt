package com.example.taskvalorpay.model

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


class imageload {
    @BindingAdapter("bind:imageUrl")
    fun setImageUrl(view: ImageView, url: String?) {
        Glide.with(view.getContext()).load(url).into(view)
    }
}