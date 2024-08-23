package com.example.sharedpreferance

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.io.BufferedReader
import java.io.InputStreamReader

class activityFileHandling : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_handling)


        var ed3 = findViewById<EditText>(R.id.editTextTextMultiLine)
        var b3 : Button = findViewById(R.id.button3)
        var b4 : Button = findViewById(R.id.button4)

        val builder = AlertDialog.Builder(this)
        b3.setOnClickListener {
            var fop = openFileOutput("myfile",Context.MODE_PRIVATE)
            fop.write(ed3.text.toString().toByteArray())
            builder.setTitle("File Handling")
            builder.setMessage("Data Saved")
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            });
            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.setNeutralButton("May Be", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(applicationContext,i.toString(),Toast.LENGTH_LONG).show()
            })
            builder.show()
        }

        b4.setOnClickListener {
            var line:String? =""
            var fip = application.openFileInput("myfile")
            var br = BufferedReader(InputStreamReader(fip))
            while (line != null) {
                line = br.readLine()
                if (line != null)
                    ed3.append(line+"\n")
            }
        }
    }
}