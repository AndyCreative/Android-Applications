package com.example.sliding_image_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var vp = findViewById<ViewFlipper>(R.id.viewFliper)
        vp.flipInterval = 3000
        vp.isAutoStart = true
        vp.setInAnimation(applicationContext,
        android.R.anim.slide_in_left)
        vp.setOutAnimation(applicationContext,
        android.R.anim.slide_out_right)
    }
}