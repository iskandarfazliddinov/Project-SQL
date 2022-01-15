package com.example.proyekt_sql.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.text.CaseMap

class MyDataBaseMenger(context: Context) {

    val myDbHelper = MyDataBaseHelper(context)
    var db:SQLiteDatabase? = null

    fun open(){
        db=myDbHelper.readableDatabase
    }
    fun insertDb(first_name: String,last_name: String , email:String,password:String,phone:Int){

        val value =ContentValues().apply {
            put(MyDataBaseBuild.FIRST_NAME,first_name)
            put(MyDataBaseBuild.LAST_NAME,last_name)
            put(MyDataBaseBuild.EMAIL,email)
            put(MyDataBaseBuild.PASSWORD,password)
            put(MyDataBaseBuild.PHONE,phone)
        }
        db?.insert(MyDataBaseBuild.TABLE_NAME,null,value)
    }

    @SuppressLint("Range")
    fun readData():ArrayList<String>{

        val dataList =ArrayList<String>()

        val cursor =db?.query(
            MyDataBaseBuild.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor){
            while (this?.moveToNext()!!){
                val dataText_1 = cursor?.getString(cursor.getColumnIndex(MyDataBaseBuild.FIRST_NAME))
                val dataText_2 = cursor?.getString(cursor.getColumnIndex(MyDataBaseBuild.LAST_NAME))
                val dataText_3 = cursor?.getString(cursor.getColumnIndex(MyDataBaseBuild.EMAIL))
                val dataText_4 = cursor?.getString(cursor.getColumnIndex(MyDataBaseBuild.PASSWORD))
                val dataText_5 = cursor?.getString(cursor.getColumnIndex(MyDataBaseBuild.PHONE))


                dataList.add("  $dataText_1"+"  $dataText_2"+"  $dataText_3"+"  $dataText_4"+"  $dataText_5")

            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDb(){
        myDbHelper.close()
    }

}