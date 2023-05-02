package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"


class MainActivity : AppCompatActivity() {

    lateinit var  rvMain : RecyclerView
    lateinit var  btn_gravar : Button
    val BASE_URL= "https://unyleya-node.onrender.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMain = findViewById(R.id.recycler_view)

        rvMain.layoutManager= LinearLayoutManager(this)
        getAllData()
        btn_gravar = findViewById(R.id.btn_GravarUrl)
        btn_gravar.setOnClickListener{
            val intent1 = Intent (this, GravarUrlActivity::class.java)
            startActivity(intent1)
        }

    }




    private fun getAllData(){
        var retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getData()
            retroData.enqueue(object: Callback<List<MyDataItem>> {
            override fun onResponse(
                call: Call<List<MyDataItem>>,
                response: Response<List<MyDataItem>>
            ) {
                var data = response.body()!!
                var myAdapter = MyAdapter(baseContext,data)
                rvMain.adapter = myAdapter
                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<MyDataItem>>, t: Throwable) {
                t.message?.let { Log.d("Erro", it) }
            }

        })
    }

}