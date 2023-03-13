package com.example.taskvalorpay.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.ActivityMainBinding
import com.example.taskvalorpay.view.adapter.UserListAdapter
import com.example.taskvalorpay.view.fragments.DownloadListFragment
import com.example.taskvalorpay.view.fragments.HomeFragment
import com.example.taskvalorpay.view.fragments.MediaFragment
import com.example.taskvalorpay.view.fragments.SearchFragment
import com.example.taskvalorpay.viewmodel.UserViewmodel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var vm: UserViewmodel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val toolbar = supportActionBar;
        vm = ViewModelProviders.of(this)[UserViewmodel::class.java]
        var fragment: Fragment
        fragment = HomeFragment()
        loadFragment(fragment)

        binding!!.bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment
            when (item.itemId) {
                R.id.nav_home -> {
                    toolbar?.setTitle("Home")
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.nav_coming_soon -> {
                    toolbar?.setTitle("Media List")
                    fragment = MediaFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.nav_search -> {
                    toolbar?.setTitle("Search")
                    fragment = SearchFragment()
                    loadFragment(fragment)
                    true

                }
                R.id.nav_download -> {
                    toolbar?.setTitle("Download List")
                    fragment = DownloadListFragment()
                    loadFragment(fragment)
                    true

                }

                else -> false
            }

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                startActivity(Intent(this,SearchingActivity::class.java))
                return true
            }
            R.id.notification -> {
                startActivity(Intent(this,NotificationActivity::class.java))
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}