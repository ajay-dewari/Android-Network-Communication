package com.dewari.ajay.androidnetworkcommunication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dewari.ajay.androidnetworkcommunication.JsonPlaceHolderApi
import com.dewari.ajay.androidnetworkcommunication.R
import com.dewari.ajay.androidnetworkcommunication.models.ToDo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java);

        val call: Call<List<ToDo>> = jsonPlaceHolderApi.toDos

        call.enqueue(object : Callback<List<ToDo>> {
            override fun onFailure(call: Call<List<ToDo>>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity, "Error: " + t.message, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onResponse(call: Call<List<ToDo>>, response: Response<List<ToDo>>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@RetrofitActivity,
                        "Success: " + response.body().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this@RetrofitActivity,
                        "Code: " + response.code() + "Error: " + response.errorBody(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        })


    }
}