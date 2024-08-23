package com.example.sharedpreferance

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ed1 = findViewById<EditText>(R.id.editTextTextPersonName)
        var ed2 = findViewById<EditText>(R.id.editTextTextPassword)

        var b1 : Button = findViewById(R.id.button)
        var b2 : Button = findViewById(R.id.button2)

        var sp = application.getSharedPreferences("userpass",Context.MODE_PRIVATE)
        var editor = sp.edit()

        ed1.setText(sp.getString("username",""))
        ed2.setText(sp.getString("password",""))

        b2.setOnClickListener {
            editor.putString("username",ed1.text.toString())
            editor.putString("password",ed2.text.toString())
            editor.commit()
            Toast.makeText(applicationContext,"Data Saved", Toast.LENGTH_LONG).show()
        }
    }
}