package com.example.taskvalorpay.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.taskvalorpay.model.UserComment
import com.example.taskvalorpay.model.UserDetails
import com.example.taskvalorpay.model.UserPost
import com.example.taskvalorpay.model.Users
import com.example.taskvalorpay.service.UserRepository

class UserViewmodel(application: Application) : AndroidViewModel(application) {
    private val userreps = UserRepository.getInstance()

    fun getAllUsers(): LiveData<List<Users>> {
        return userreps.getuserlistfromserver()
    }

   fun getUserDetails(id:String):LiveData<UserDetails>{
        return userreps.getuserdetatilsfromserver(id)
    }
    fun getUserPost(id:String):LiveData<List<UserPost>>{
        return userreps.geruserpostfromserver(id)
    }
    fun getUserComments(id:String):LiveData<List<UserComment>>{
        return userreps.getusercommentsfromserver(id)
    }

}