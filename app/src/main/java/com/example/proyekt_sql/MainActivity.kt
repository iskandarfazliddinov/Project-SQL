package com.example.proyekt_sql

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyekt_sql.DataBase.MyAdapter
import com.example.proyekt_sql.DataBase.MyDataBaseMenger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val myDbManger = MyDataBaseMenger(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        creatButton.setOnClickListener {
            val name = first_name.text.toString()
            val last_name = last_name.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val phone = phone.text.toString()

            myDbManger.insertDb(name,last_name,email,password,932263066)
            val i = Intent(this,MainActivity3::class.java)
            startActivity(i)
        }

    }


    override fun onResume() {
        super.onResume()
        myDbManger.open()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManger.closeDb()
    }

    fun singButton(view: android.view.View) {


        val i = Intent(this,MainActivity2::class.java)
        startActivity(i)
    }

}