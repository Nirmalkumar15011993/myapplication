package com.example.taskvalorpay.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityMainBinding
import com.example.taskvalorpay.service.NetworkStatus
import com.example.taskvalorpay.service.NetworkStatusHelper
import com.example.taskvalorpay.view.adapter.UserListAdapter
import com.example.taskvalorpay.viewmodel.UserViewmodel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var useradapter: UserListAdapter? = null
    private var vm: UserViewmodel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Home"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProviders.of(this)[UserViewmodel::class.java]

        NetworkStatusHelper(this).observe(this) {

            if(it){
                loaduserdata()
            }else{
                nointernetconnection()
            }
        }


        binding!!.bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_home -> {

                    true
                }
                R.id.nav_coming_soon -> {

                    true

                }
                R.id.nav_search -> {

                    true

                }
                R.id.nav_download -> {

                    true

                }

                else -> false
            }

        }
    }

    fun loaduserdata() {
        binding?.onactive?.visibility = View.VISIBLE
        binding?.ondeactive?.visibility = View.GONE
        binding?.prg?.visibility = View.VISIBLE
        vm?.getAllUsers()?.observe(this, Observer {
            binding?.prg?.visibility = View.GONE
            useradapter = UserListAdapter(it.toMutableList(), this)
            binding?.rvusers?.adapter = useradapter
            useradapter?.notifyDataSetChanged()
        })
    }
    fun nointernetconnection(){
        binding?.onactive?.visibility = View.GONE
        binding?.ondeactive?.visibility = View.VISIBLE
        Toast.makeText(this,"No Internet Connectivity",Toast.LENGTH_LONG).show()
    }
}