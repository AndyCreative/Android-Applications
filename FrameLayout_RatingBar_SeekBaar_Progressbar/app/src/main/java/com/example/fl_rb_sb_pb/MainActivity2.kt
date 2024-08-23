package com.example.fl_rb_sb_pb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        
        var rb :RatingBar = findViewById(R.id.ratingBar)
        var tv : TextView = findViewById(R.id.textView3)
        var tv2 : TextView = findViewById(R.id.textView4)

        var sb : SeekBar = findViewById(R.id.seekBar)

        rb.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { ratingBar, fl, b ->
            tv.setText("RatingBar Value : $fl")
        })

        sb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv2.setText("SeekBar value : $p1")
                sb.secondaryProgress = p1 + 10
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}