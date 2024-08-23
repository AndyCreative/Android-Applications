package com.example.implicit_explicit_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var surnameText : TextView = findViewById(R.id.surname)
        var nameText : TextView = findViewById(R.id.name)

        val intent: Intent = intent
        var surname = intent.getStringExtra("surname")
        var name = intent.getStringExtra("name")

        surnameText.text = surname.toString()
        nameText.text = name.toString()

        /* var bundle : Bundle ?= intent.extras
        var message = bundle!!.getString("surname") // 1
        var strUser = bundle!!.getString("name") // 2

        surnameText.text = message.toString()
        nameText.text = strUser.toString()*/

        var weburl : Button = findViewById(R.id.weburl)
        var dialnumber : Button = findViewById(R.id.dialnumber)
        var map : Button = findViewById(R.id.map)

        weburl.setOnClickListener{
            var uri = Uri.parse("https://google.com")
            var i = Intent(Intent.ACTION_VIEW, uri)
            startActivity(i)
        }

        var number : EditText = findViewById(R.id.number)
        dialnumber.setOnClickListener {
            var uri = Uri.parse("tel:"+number.text.toString())
            var i = Intent(Intent.ACTION_DIAL, uri)
            startActivity(i)
        }

        map.setOnClickListener {
            var uri = Uri.parse("geo:0,0?q="+"Atmiya University, Rajkot")
            var i = Intent(Intent.ACTION_VIEW, uri)
            startActivity(i)
        }
    }
}