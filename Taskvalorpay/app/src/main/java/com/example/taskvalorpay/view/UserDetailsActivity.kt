package com.example.taskvalorpay.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityMainBinding
import com.example.taskvalorpay.databinding.ActivityUserdetailsBinding
import com.example.taskvalorpay.service.NetworkStatusHelper
import com.example.taskvalorpay.viewmodel.UserViewmodel

class UserDetailsActivity : AppCompatActivity() {
    private var binding: ActivityUserdetailsBinding? = null
    private var vm: UserViewmodel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userdetails)
        vm = ViewModelProviders.of(this)[UserViewmodel::class.java]
        NetworkStatusHelper(this).observe(this) {

            if(it){
                loaduserdetails()
            }else{
                nointernetconnection()
            }
        }


        binding?.btshowpost?.setOnClickListener {
            val i = Intent(this, ShowPostActivity::class.java)
            i.putExtra("userid", binding?.userdetails?.id)
            startActivity(i)
        }
    }

    fun loaduserdetails() {
        binding?.onactive?.visibility = View.VISIBLE
        binding?.ondeactive?.visibility = View.GONE
        binding?.prg?.visibility = View.VISIBLE
        val id = intent.getStringExtra("userid")
        vm?.getUserDetails(id!!)?.observe(this, Observer {
            binding?.prg?.visibility = View.GONE
            binding?.userdetails = it
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