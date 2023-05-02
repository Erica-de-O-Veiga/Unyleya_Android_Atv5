package com.example.myapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


lateinit var  btnEnviar : Button
class GravarUrlActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gravar_url)


        val btnGravar = findViewById<Button>(R.id.btnEnviar)
        val tvUrl= findViewById<EditText>(R.id.tvUrl)
        val tvCode= findViewById<EditText>(R.id.tvCode)
        val tvId = findViewById<EditText>(R.id.tvId)

        lateinit var  btn_gravar : Button
        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener{
       /*    val objurl : MyDataItem= MyDataItem();
            objurl .url= tvUrl.text.toString()
            objurl.code = tvCode.text.toString()
            objurl.id = tvId.text.toString()*/


        }
    }


}