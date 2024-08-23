package com.example.typesbuttondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.button)
        var imgbtn : ImageButton = findViewById(R.id.imageButton)
        var tgb : ToggleButton = findViewById(R.id.toggleButton)
        var imgview : ImageView = findViewById(R.id.imageView)
        var sw : Switch = findViewById(R.id.switch1)
        var floatbtn : FloatingActionButton = findViewById(R.id.floatingActionButton)

        btn.setOnClickListener {
            Toast.makeText(applicationContext,"Button Clicked",Toast.LENGTH_LONG).show()
        }

        imgbtn.setOnClickListener {
            Toast.makeText(applicationContext,"Image Button Clicked",Toast.LENGTH_LONG).show()
        }

        tgb.setOnClickListener {
            if(tgb.text.equals("OFF")){
                imgview.setImageResource(R.drawable.off)
            }else{
                imgview.setImageResource(R.drawable.on)
            }
        }

        sw.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                imgview.setImageResource(R.drawable.on)
            }else{
                imgview.setImageResource(R.drawable.off)
            }
        }

        floatbtn.setOnClickListener {
            Toast.makeText(applicationContext,"Floating Button Clicked",Toast.LENGTH_LONG).show()
        }

        var cb1 : CheckBox = findViewById(R.id.checkBox)
        var cb2 : CheckBox = findViewById(R.id.checkBox2)
        var cb3 : CheckBox = findViewById(R.id.checkBox3)
        var skilltext : TextView = findViewById(R.id.textView)

        cb1.setOnClickListener {
            var str = "Java : ${cb1.isChecked}\nPython : ${cb2.isChecked}\nAndroid : ${cb3.isChecked}"
            skilltext.setText(str)
        }
        cb2.setOnClickListener {
            var str = "Java : ${cb1.isChecked}\nPython : ${cb2.isChecked}\nAndroid : ${cb3.isChecked}"
            skilltext.setText(str)
        }
        cb3.setOnClickListener {
            var str = "Java : ${cb1.isChecked}\nPython : ${cb2.isChecked}\nAndroid : ${cb3.isChecked}"
            skilltext.setText(str)
        }

        var rg : RadioGroup = findViewById(R.id.radioGroup)
        var tv2 : TextView = findViewById(R.id.textView2)

        rg.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb!=null){
                tv2.setText(rb.text)
            }
        }

        var reset : Button = findViewById(R.id.button2)
        reset.setOnClickListener {
            rg.clearCheck()
            tv2.setText("Select Options")
        }
    }
}