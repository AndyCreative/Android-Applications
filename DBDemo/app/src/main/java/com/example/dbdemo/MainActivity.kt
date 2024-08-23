package com.example.dbdemo

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var edName: EditText
    lateinit var edSem: EditText
    lateinit var buClear : Button
    lateinit var rs : Cursor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.edName)
        edSem = findViewById(R.id.edSem)

        buClear = findViewById(R.id.buClear)
        var buInset = findViewById<Button>(R.id.buInsert)
        var buUpdate = findViewById<Button>(R.id.buUpdate)
        var buDelete = findViewById<Button>(R.id.buDelete)
        var buNext = findViewById<Button>(R.id.buNext)
        var buPrev = findViewById<Button>(R.id.buPrev)
        var buFirst = findViewById<Button>(R.id.buFirst)
        var buLast = findViewById<Button>(R.id.buLast)
        var buAll = findViewById<Button>(R.id.buAll)
        var sv = findViewById<SearchView>(R.id.searchView)
        var lv = findViewById<ListView>(R.id.listView)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT",null)

        buClear.setOnClickListener {
            clear()
        }
        if(rs.moveToNext()){
            edName.setText(rs.getString(1))
            edSem.setText(rs.getString(2))
        }

        buInset.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME",edName.text.toString())
            cv.put("SEM",edSem.text.toString())
            db.insert("STUDENT",null,cv)
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT",null)
            showMessege("Record Inseted")
            clear()
        }

        buUpdate.setOnClickListener {
            var cv = ContentValues()
            cv.put("SNAME",edName.text.toString())
            cv.put("SEM",edSem.text.toString())
            db.update("STUDENT",cv,"SID =?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT",null)
            showMessege("Record Updated")
            clear()
        }

        buDelete.setOnClickListener {
            db.delete("STUDENT","SID=?", arrayOf(rs.getString(0)))
            rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT",null)
            showMessege("Record Deleted")
            clear()
        }

        buNext.setOnClickListener {
            if(rs.moveToNext()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            } else if(rs.moveToFirst()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            }else
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()
        }

        buPrev.setOnClickListener {
            if(rs.moveToPrevious()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            } else if(rs.moveToLast()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            }else
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()
        }

        buLast.setOnClickListener {
            if(rs.moveToLast()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            }else
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()
        }
        buFirst.setOnClickListener {
            if(rs.moveToFirst()){
                edName.setText(rs.getString(1))
                edSem.setText(rs.getString(2))
            }else
                Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()
        }


        buAll.setOnClickListener {
            sv.isIconified = false
            sv.queryHint = "Search Among ${rs.count} Records"


            var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,
                arrayOf("SNAME","SEM"),
                intArrayOf(android.R.id.text1,android.R.id.text2),0
            )
            lv.adapter = adapter

            sv.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENT WHERE SNAME LIKE '%${p0}%'",null)
                    adapter.changeCursor(rs)
                    return false
                }

            })
        }
    }

    private fun showMessege(s: String) {
        AlertDialog.Builder(this).setTitle("Success !!")
            .setMessage(s)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                if(rs.moveToFirst()){
                    edName.setText(rs.getString(1))
                    edSem.setText(rs.getString(2))
                }else
                    Toast.makeText(applicationContext,"Data Not Found",Toast.LENGTH_LONG).show()
            }).show()
    }

    private fun clear() {
        edName.setText("")
        edSem.setText("")
        edName.requestFocus()
    }
}