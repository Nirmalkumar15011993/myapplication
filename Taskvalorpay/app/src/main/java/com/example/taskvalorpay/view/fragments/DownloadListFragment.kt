package com.example.taskvalorpay.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.service.NetworkStatusHelper
import com.example.taskvalorpay.viewmodel.UserViewmodel

class DownloadListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return  return inflater.inflate(R.layout.fragment_download_list, container, false)
    }
}