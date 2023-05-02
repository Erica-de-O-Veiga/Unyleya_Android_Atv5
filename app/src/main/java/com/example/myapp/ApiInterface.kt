package com.example.myapp
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET ( "/")
    fun getData(): Call <List<MyDataItem>>

    @POST
     fun post(json:String)


}