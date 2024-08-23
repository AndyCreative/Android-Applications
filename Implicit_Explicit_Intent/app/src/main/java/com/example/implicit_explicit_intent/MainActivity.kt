package com.example.implicit_explicit_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var surname : EditText = findViewById(R.id.surname)
        var name : EditText = findViewById(R.id.name)
        var btn : Button = findViewById(R.id.button)

        btn.setOnClickListener {
            var i = Intent(this,MainActivity2::class.java)
            i.putExtra("surname", surname.text.toString())
            i.putExtra("name", name.text.toString())
            startActivity(i)
        }
    }
}