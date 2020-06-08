package com.dewari.ajay.androidnetworkcommunication.models

import com.google.gson.annotations.SerializedName

class ToDo {
    @SerializedName("id")
    val id = 0

    @SerializedName("userId")
    val userId = 0

    @SerializedName("title")
    val title: String? = null

    @SerializedName("completed")
    val isCompleted = false

}