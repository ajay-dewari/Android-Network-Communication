package com.dewari.ajay.androidnetworkcommunication;

import com.dewari.ajay.androidnetworkcommunication.models.ToDo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("todos")
    Call<List<ToDo>> getToDos();
}
