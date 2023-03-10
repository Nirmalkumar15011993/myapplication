package com.example.taskvalorpay.model

import com.google.gson.annotations.SerializedName

data class UserDetails (
    @SerializedName("id")
    var id:String?= null,
    @SerializedName("name")
    var name:String?= null,
    @SerializedName("username")
    var username:String?= null,
    @SerializedName("email")
    var email:String?= null,
    @SerializedName("phone")
    var phone:String?= null,
    @SerializedName("website")
    var website:String?= null,
    @SerializedName("address")
    var address:AddressDetails?= null)