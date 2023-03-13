package com.example.taskvalorpay.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskvalorpay.R

class NotificationActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_notification)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}