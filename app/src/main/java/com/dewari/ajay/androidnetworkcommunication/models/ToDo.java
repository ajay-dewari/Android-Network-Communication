package com.dewari.ajay.androidnetworkcommunication.models;

import com.google.gson.annotations.SerializedName;

public class ToDo {

    @SerializedName("id")
    private int id;

    @SerializedName("userId")
    private int userId;

    @SerializedName("title")
    private String title;

    @SerializedName("completed")
    private boolean completed;
}
