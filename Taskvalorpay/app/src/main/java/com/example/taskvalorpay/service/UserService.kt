package com.example.taskvalorpay.service

import com.example.taskvalorpay.model.UserComment
import com.example.taskvalorpay.model.UserDetails
import com.example.taskvalorpay.model.UserPost
import com.example.taskvalorpay.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/users")
    fun getUserList(): Call<List<Users>>

    @GET("/users/{id}")
    fun getUserDetails(@Path("id") id: String): Call<UserDetails>

    @GET("/users/{id}/posts")
    fun getUserPost(@Path("id") id: String): Call<List<UserPost>>

    @GET("/posts/{postid}/comments")
    fun getUserCommets(@Path("postid") postid: String): Call<List<UserComment>>
}