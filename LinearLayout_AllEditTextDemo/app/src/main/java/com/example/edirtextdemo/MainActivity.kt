package com.example.edirtextdemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email : EditText = findViewById(R.id.emailedittext)

        var atv = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        var city = arrayOf("Amreli","Ahmedabad","Anand","Dhari","Derdi")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item,city)
        //var adapter = ArrayAdapter<String>(this,R.layout.my_layout,city)
        atv.setAdapter(adapter)

        var mtv = findViewById<MultiAutoCompleteTextView>(R.id.multiAutoCompleteTextView)
        var skills = arrayOf("Java","Android","CPP","C#","PHP","Python")
        var adapter2 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,skills)
        mtv.setAdapter(adapter2)
        mtv.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())


        email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(p0).matches()){
                    email.setError("Invalid Email")
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        var date = findViewById<EditText>(R.id.editTextDate)
        var c = Calendar.getInstance()
        /*date.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                date.setText("$i3/${i2+1}/$i")
                Toast.makeText(applicationContext,"$i3/${i2+1}/$i",Toast.LENGTH_LONG).show()
            },c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()
        }*/

        date.setOnClickListener {
            DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->  },
                2023,9,15).show()
        }

        var time = findViewById<EditText>(R.id.editTextTime)
        time.setOnClickListener {
            TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                time.setText("$i : $i2")
            },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false).show()
        }
    }
}