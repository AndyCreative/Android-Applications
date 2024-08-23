package com.example.custom_content_provider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class Display_Activity : AppCompatActivity() {
    var cols = arrayOf(AcronymProvider.NAME,AcronymProvider.MEANING,AcronymProvider._ID)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        var lv = findViewById<ListView>(R.id.listView1)
        var rs = contentResolver.query(AcronymProvider.CONTENT_URI,cols,null,null,null)
        var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,cols,
            intArrayOf(android.R.id.text1,android.R.id.text2))
        lv.adapter = adapter
    }
}