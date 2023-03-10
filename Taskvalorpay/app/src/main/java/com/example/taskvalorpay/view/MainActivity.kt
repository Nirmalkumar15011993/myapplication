package com.example.taskvalorpay.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityMainBinding
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
        binding?.prg?.visibility = View.VISIBLE
        loaduserdata()

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
        vm?.getAllUsers()?.observe(this, Observer {
            binding?.prg?.visibility = View.GONE
            useradapter = UserListAdapter(it.toMutableList(), this)
            binding?.rvusers?.adapter = useradapter
            useradapter?.notifyDataSetChanged()
        })
    }
}