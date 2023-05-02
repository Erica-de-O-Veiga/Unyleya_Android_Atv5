package com.example.myapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitClient {
    var retrofit : Retrofit = TODO()

    public fun  getRetrofitInstance() : Retrofit{

        if (retrofit==null) {
            var retrofit  = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }
        return retrofit

        }


}