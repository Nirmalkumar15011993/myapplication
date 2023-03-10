package com.example.taskvalorpay.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskvalorpay.model.UserComment
import com.example.taskvalorpay.model.UserDetails
import com.example.taskvalorpay.model.UserPost
import com.example.taskvalorpay.model.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {

    private val HTTPS_API_USER = "https://jsonplaceholder.typicode.com"
    private var userService: UserService? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(HTTPS_API_USER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        userService = retrofit.create(UserService::class.java)
    }

    companion object {
        private var userRepository: UserRepository? = null

        @Synchronized
        @JvmStatic
        fun getInstance(): UserRepository {
            if (userRepository == null) {
                userRepository = UserRepository()
            }
            return userRepository!!
        }
    }

    fun getuserlistfromserver(): LiveData<List<Users>> {
        val data = MutableLiveData<List<Users>>()
        userService?.getUserList()?.enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                data.value = response.body()

            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {

            }

        })
        return data
    }
    fun getuserdetatilsfromserver(id : String):LiveData<UserDetails>{
        val data = MutableLiveData<UserDetails>()
        userService?.getUserDetails(id)?.enqueue(object :Callback<UserDetails>{
            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<UserDetails>, t: Throwable) {

            }

        })
        return  data
    }
    fun geruserpostfromserver(id:String):LiveData<List<UserPost>>{
        val data = MutableLiveData<List<UserPost>>()
        userService?.getUserPost(id)?.enqueue(object : Callback<List<UserPost>>{
            override fun onResponse(
                call: Call<List<UserPost>>,
                response: Response<List<UserPost>>,
            ) {
               data.value = response.body()
            }

            override fun onFailure(call: Call<List<UserPost>>, t: Throwable) {

            }

        })
        return data
    }
    fun getusercommentsfromserver(postid: String):LiveData<List<UserComment>>{
        val data = MutableLiveData<List<UserComment>>()
        userService?.getUserCommets(postid)?.enqueue(object :Callback<List<UserComment>>{
            override fun onResponse(
                call: Call<List<UserComment>>,
                response: Response<List<UserComment>>,
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<List<UserComment>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return data
    }
}