package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview : ListView = findViewById(R.id.listview)
        var city = arrayOf("Ahmedabad","Rajkot","Surat","Baroda")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            var value =listview.getItemAtPosition(i).toString()
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }
    }
}