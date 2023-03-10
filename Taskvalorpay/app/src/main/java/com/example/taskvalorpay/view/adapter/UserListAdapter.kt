package com.example.taskvalorpay.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.UserListItemBinding
import com.example.taskvalorpay.model.Users
import com.example.taskvalorpay.view.UserDetailsActivity

class UserListAdapter(val items: MutableList<Users>, val context: Context) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    class ViewHolder(val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DataBindingUtil.inflate<UserListItemBinding>(LayoutInflater.from(parent.context),
                R.layout.user_list_item,
                parent,
                false)
        return ViewHolder(binding)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = items[position]
        holder.binding.cvuser.setOnClickListener {
         val i  = Intent(context, UserDetailsActivity::class.java)
            i.putExtra("userid",items[position].id)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
}