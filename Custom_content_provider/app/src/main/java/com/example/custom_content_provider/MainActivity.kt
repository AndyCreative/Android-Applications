package com.example.custom_content_provider

import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var cols = arrayOf(AcronymProvider._ID,AcronymProvider.NAME,AcronymProvider.MEANING)
    lateinit var rs :Cursor
    lateinit var ed1 :EditText
    lateinit var ed2 :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rs = contentResolver.query(AcronymProvider.CONTENT_URI,cols,null,null,null)!!

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        var b1 = findViewById<Button>(R.id.button)
        var b2 = findViewById<Button>(R.id.button2)
        var b3 = findViewById<Button>(R.id.button3)
        var b4 = findViewById<Button>(R.id.button4)
        var b5 = findViewById<Button>(R.id.button5)
        var b6 = findViewById<Button>(R.id.button6)
        var b7 = findViewById<Button>(R.id.button7)
        var b8 = findViewById<Button>(R.id.button8)

        if(rs.moveToFirst()){
            ed1.setText(rs.getString(1))
            ed2.setText(rs.getString(2))
        }else{
            alert("Not Found")
        }

        b1.setOnClickListener {
            if(rs.moveToNext()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else if(rs.moveToFirst()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else{
                alert("Not Found")
            }
        }
        b2.setOnClickListener {
            if(rs.moveToPrevious()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else if(rs.moveToLast()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else{
                alert("Not Found")
            }
        }
        b3.setOnClickListener {
            if(rs.moveToFirst()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else{
                alert("Not Found")
            }
        }
        b4.setOnClickListener {
            if(rs.moveToLast()){
                ed1.setText(rs.getString(1))
                ed2.setText(rs.getString(2))
            }else{
                alert("Not Found")
            }
        }

        b5.setOnClickListener {
            var cv = ContentValues()
            cv.put(AcronymProvider.NAME,ed1.text.toString())
            cv.put(AcronymProvider.MEANING,ed2.text.toString())
            contentResolver.insert(AcronymProvider.CONTENT_URI,cv)
            rs.requery()
            alert("Inserted")
            firstRecord()
        }

        b6.setOnClickListener {
            var cv = ContentValues()
            cv.put(AcronymProvider.NAME,ed1.text.toString())
            cv.put(AcronymProvider.MEANING,ed2.text.toString())
            contentResolver.update(AcronymProvider.CONTENT_URI,cv,"NAME=?", arrayOf(ed1.text.toString()))
            rs.requery()
            alert("Updated")
            firstRecord()
        }
        b7.setOnClickListener {
            var cv = ContentValues()
            contentResolver.delete(AcronymProvider.CONTENT_URI,"NAME=?", arrayOf(ed1.text.toString()))
            rs.requery()
            alert("Deleted")
            firstRecord()
        }
        b8.setOnClickListener {
            clear()
        }

        var b9 = findViewById<Button>(R.id.button9)
        b9.setOnClickListener {
            startActivity(Intent(applicationContext,Display_Activity::class.java))
        }
    }

    private fun alert(s: String) {
        AlertDialog.Builder(this).setMessage(s).setTitle("Empty").setPositiveButton("Ok",null).show()
    }

    private fun clear() {
        ed1.setText("")
        ed2.setText("")
        ed1.requestFocus()
    }

    private fun firstRecord() {
        if(rs.moveToFirst()){
            ed1.setText(rs.getString(1))
            ed2.setText(rs.getString(2))
        }else{
            alert("Not Found")
        }
    }
}