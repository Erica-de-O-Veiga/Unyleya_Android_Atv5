package com.example.myapp

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class HttpHelper {
    fun post (json: String) : String {
         val URL = "https://unyleya-node.onrender.com/"

        val headerHttp = "aplication/json,charset=utf-8".toMediaTypeOrNull()

        val cliente = OkHttpClient()

        val body = json.toRequestBody(headerHttp)

        val request = Request.Builder().url(URL).post(body).build()

        val response = cliente.newCall(request).execute()

        return response.body.toString()
    }
}