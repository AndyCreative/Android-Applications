package com.example.custom_content_provider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context : Context) : SQLiteOpenHelper(context,"AcronymDB",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE ACTABLE (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, MEANING TEXT)")
        p0?.execSQL("INSERT INTO ACTABLE(NAME,MEANING) VALUES('MCA','MASTER OF COMPUTER APPLICATION')")
        p0?.execSQL("INSERT INTO ACTABLE(NAME,MEANING) VALUES('BCA','BECHOLOR OF COMPUTER APPLICATION')")
        p0?.execSQL("INSERT INTO ACTABLE(NAME,MEANING) VALUES('WWW','WORLD WIDE WEB')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}