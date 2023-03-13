package com.example.taskvalorpay.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskvalorpay.R

class SearchingActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.fragment_search)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}