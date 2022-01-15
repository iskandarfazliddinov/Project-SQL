package com.example.proyekt_sql.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDataBaseHelper(context: Context):SQLiteOpenHelper(
    context,MyDataBaseBuild.DATABASE_NAME,null,MyDataBaseBuild.DATABASE_VERSION
){
    //jadval yaratilishi
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDataBaseBuild.SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDataBaseBuild.SQL_DELETE_ENTERIES)
        onCreate(db)
    }


}
