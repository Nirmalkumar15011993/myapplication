package com.example.taskvalorpay.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.UserCommentItemBinding
import com.example.taskvalorpay.databinding.UserPostItemBinding
import com.example.taskvalorpay.model.UserComment

class UserCommetsAdapter(val items: MutableList<UserComment>, val context: Context) :
    RecyclerView.Adapter<UserCommetsAdapter.ViewHolder>() {
    class ViewHolder(val binding: UserCommentItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DataBindingUtil.inflate<UserCommentItemBinding>(LayoutInflater.from(parent.context),
                R.layout.user_comment_item,
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.usercomment = items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }
}