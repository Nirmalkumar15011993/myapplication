package com.example.taskvalorpay.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("phone")
    var phoneno: String? = null
)