package com.example.taskvalorpay.model

import com.google.gson.annotations.SerializedName

data class UserPost (
    @SerializedName("userId")
    var userId :String?=null,
    @SerializedName("id")
    var id :String?=null,
    @SerializedName("title")
    var title :String?=null,
    @SerializedName("body")
    var body :String?=null
)