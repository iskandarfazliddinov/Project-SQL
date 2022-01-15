package com.example.proyekt_sql.DataBase

import android.provider.BaseColumns

object MyDataBaseBuild {

    const val TABLE_NAME = "my_table"
    const val FIRST_NAME = "first_name"
    const val LAST_NAME = "last_name"
    const val EMAIL = "email"
    const val PASSWORD = "password"
    const val PHONE = "phone"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "table.db"

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$FIRST_NAME TEXT," +
                "$LAST_NAME TEXT,"+
                "$EMAIL TEXT,"+
                "$PASSWORD TEXT,"+
                "$PHONE TEXT)"

    const val SQL_DELETE_ENTERIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}