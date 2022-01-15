package com.example.proyekt_sql.DataBase

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyekt_sql.R

class MyAdapter(listMain:ArrayList<String>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArry = listMain

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val tv : TextView = itemView.findViewById(R.id.textView)

        fun setData(title:String){
             tv.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(inflater.inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(listArry[position])
    }

    override fun getItemCount(): Int {
        return listArry.size
    }

    fun updataAdapter(listItem:ArrayList<String>){
        listArry.clear()
        listItem.addAll(listItem)
        notifyDataSetChanged()
    }
}