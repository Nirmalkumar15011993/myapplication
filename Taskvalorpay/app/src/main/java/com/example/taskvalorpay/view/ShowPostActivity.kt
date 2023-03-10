package com.example.taskvalorpay.view

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityShowpostBinding
import com.example.taskvalorpay.databinding.ActivityUserdetailsBinding
import com.example.taskvalorpay.view.adapter.ShowPostAdapter
import com.example.taskvalorpay.view.adapter.UserListAdapter
import com.example.taskvalorpay.viewmodel.UserViewmodel

class ShowPostActivity : AppCompatActivity() {
    private var binding: ActivityShowpostBinding? = null
    private var vm: UserViewmodel? = null
    private var userpostadapter: ShowPostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_showpost)

        vm = ViewModelProviders.of(this)[UserViewmodel::class.java]

        binding?.prg?.visibility = View.VISIBLE
        loaduserpost()
    }

    fun loaduserpost() {
        val id = intent.getStringExtra("userid")
        vm?.getUserPost(id!!)?.observe(this, Observer {
            binding?.prg?.visibility = View.GONE
            userpostadapter = ShowPostAdapter(it.toMutableList(), vm!!)
            binding?.rvpost?.adapter = userpostadapter
            userpostadapter?.notifyDataSetChanged()
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}