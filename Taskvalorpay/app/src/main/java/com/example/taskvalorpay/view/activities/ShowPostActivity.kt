package com.example.taskvalorpay.view.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityShowpostBinding
import com.example.taskvalorpay.service.NetworkStatusHelper
import com.example.taskvalorpay.view.adapter.ShowPostAdapter
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

        NetworkStatusHelper(this).observe(this) {

            if(it){
                loaduserpost()
            }else{
                nointernetconnection()
            }
        }

    }

    fun loaduserpost() {
        binding?.onactive?.visibility = View.VISIBLE
        binding?.ondeactive?.visibility = View.GONE
        binding?.prg?.visibility = View.VISIBLE
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

    fun nointernetconnection(){
        binding?.onactive?.visibility = View.GONE
        binding?.ondeactive?.visibility = View.VISIBLE
        Toast.makeText(this,"No Internet Connectivity", Toast.LENGTH_LONG).show()
    }

}