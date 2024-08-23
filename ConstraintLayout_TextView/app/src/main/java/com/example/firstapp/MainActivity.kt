package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview : TextView = findViewById(R.id.textView5)
        //var tv = findViewById<TextView>(R.id.textView)

        textview.setOnClickListener{
            Toast.makeText(applicationContext,textview.text,Toast.LENGTH_LONG).show()
        }
/*        textview.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Hello",Toast.LENGTH_LONG).show()
        })*/
    }
}