package com.example.taskvalorpay.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.taskvalorpay.R
import com.example.taskvalorpay.databinding.FragmentHomeBinding
import com.example.taskvalorpay.service.NetworkStatusHelper
import com.example.taskvalorpay.view.adapter.UserListAdapter
import com.example.taskvalorpay.viewmodel.UserViewmodel

class HomeFragment : Fragment() {
    private var binding : FragmentHomeBinding?=null
    private var useradapter: UserListAdapter? = null
    private var vm: UserViewmodel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        vm = ViewModelProviders.of(this)[UserViewmodel::class.java]
        NetworkStatusHelper(inflater.context).observe(viewLifecycleOwner) {

            if(it){
                loaduserdata()
            }else{
                nointernetconnection()
            }
        }
        return binding!!.root
    }
    fun loaduserdata() {
        binding?.onactive?.visibility = View.VISIBLE
        binding?.ondeactive?.visibility = View.GONE
        binding?.prg?.visibility = View.VISIBLE
        vm?.getAllUsers()?.observe(viewLifecycleOwner, Observer {
            binding?.prg?.visibility = View.GONE
            useradapter = UserListAdapter(it.toMutableList(), layoutInflater.context)
            binding?.rvusers?.adapter = useradapter
            useradapter?.notifyDataSetChanged()
        })
    }
    fun nointernetconnection(){
        binding?.onactive?.visibility = View.GONE
        binding?.ondeactive?.visibility = View.VISIBLE
        Toast.makeText(layoutInflater.context,"No Internet Connectivity", Toast.LENGTH_LONG).show()
    }
}