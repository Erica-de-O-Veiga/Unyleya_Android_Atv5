package com.example.myapp

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var con : Context, var list: List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
        var tv_Url = v.findViewById<TextView>(R.id.tvUrl)
        var tv_Code = v.findViewById<TextView>(R.id.tvCode)
        var tv_Id = v.findViewById<TextView>(R.id.tvId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con)
            .inflate(
                R.layout.list_item,
                parent,
                false
            )
        return ViewHolder((view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.tv_Url.text = "Url: ${list[position].url}"
        holder.tv_Code.text = "Code: ${list[position].code}"
        holder.tv_Id.text = "Id: ${list[position].id.toString()}"
    }

    override fun getItemCount(): Int = list.count()

}