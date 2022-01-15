package com.example.proyekt_sql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyekt_sql.DataBase.MyAdapter
import com.example.proyekt_sql.DataBase.MyDataBaseMenger

class MainActivity3 : AppCompatActivity() {

    val myDbManger = MyDataBaseMenger(this)
    val myAdapter = MyAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        init()

    }
    override fun onResume() {
        super.onResume()
        myDbManger.open()
        AllAdapterItems()

    }

    fun AllAdapterItems() {
        myAdapter.updataAdapter(myDbManger.readData())
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManger.closeDb()
    }
    fun init(){
        val reycler :RecyclerView = findViewById(R.id.myRecyclerView)
        reycler.layoutManager = LinearLayoutManager(this)
        reycler.adapter =myAdapter
    }

}