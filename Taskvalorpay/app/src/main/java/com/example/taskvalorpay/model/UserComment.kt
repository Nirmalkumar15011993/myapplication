package com.example.taskvalorpay.model

import com.google.gson.annotations.SerializedName

data class UserComment(
    @SerializedName("postId")
    var postId: String? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("body")
    var body: String? = null
)