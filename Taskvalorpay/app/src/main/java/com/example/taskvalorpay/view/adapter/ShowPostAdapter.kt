package com.example.taskvalorpay.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityUserdetailsBinding
import com.example.taskvalorpay.databinding.UserListItemBinding
import com.example.taskvalorpay.databinding.UserPostItemBinding
import com.example.taskvalorpay.model.UserPost
import com.example.taskvalorpay.viewmodel.UserViewmodel

class ShowPostAdapter(val items: MutableList<UserPost>, val userViewmodel: UserViewmodel) :
    RecyclerView.Adapter<ShowPostAdapter.ViewHolder>() {
    private lateinit var context: Context

    class ViewHolder(val binding: UserPostItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DataBindingUtil.inflate<UserPostItemBinding>(LayoutInflater.from(parent.context),
                R.layout.user_post_item,
                parent,
                false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.postitem = items[position]
        holder.binding.viewcomment.setOnClickListener {
            val builder = AlertDialog.Builder(context)
                .create()
            val view = LayoutInflater.from(context).inflate(R.layout.customview_layout, null)
            val rvcomment = view.findViewById<RecyclerView>(R.id.rvcomment)
            val prg = view.findViewById<ProgressBar>(R.id.prgdialogue)
            builder.setView(view)
            prg.visibility = View.VISIBLE
            builder.setCanceledOnTouchOutside(false)
            builder.show()
            userViewmodel?.getUserComments(items[position].id!!)
                ?.observe(context as LifecycleOwner, Observer {
                    prg.visibility = View.GONE
                    val useradapter = UserCommetsAdapter(it.toMutableList(), context)
                    rvcomment.adapter = useradapter
                    useradapter?.notifyDataSetChanged()
                })
        }

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun getItemCount(): Int {
        return items.size
    }


}