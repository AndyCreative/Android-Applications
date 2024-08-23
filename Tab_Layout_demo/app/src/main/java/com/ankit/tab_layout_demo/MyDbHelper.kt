package com.ankit.tab_layout_demo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context): SQLiteOpenHelper(context,"collegeDB",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE COLLEGE (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SEM INTEGER,COLLEGE TEXT,PHONE INTEGER)")
        p0?.execSQL("INSERT INTO COLLEGE (NAME,SEM,COLLEGE,PHONE) VALUES('DHALAK',3,'ATMIYA UNIVERSITY',9999999999)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}