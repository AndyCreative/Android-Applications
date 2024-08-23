package com.example.animationframebyframe

import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()
        var frame1 = resources.getDrawable(R.drawable.frame1,null)
        var frame2 = resources.getDrawable(R.drawable.frame2,null)
        var frame3 = resources.getDrawable(R.drawable.frame3,null)
        var frame4 = resources.getDrawable(R.drawable.frame4,null)
        var frame5 = resources.getDrawable(R.drawable.frame5,null)
        var frame6 = resources.getDrawable(R.drawable.frame6,null)
        var frame7 = resources.getDrawable(R.drawable.frame7,null)

        ad.addFrame(frame1,30)
        ad.addFrame(frame2,30)
        ad.addFrame(frame3,30)
        ad.addFrame(frame4,30)
        ad.addFrame(frame5,30)
        ad.addFrame(frame6,30)
        ad.addFrame(frame7,30)

        var iv = findViewById<ImageView>(R.id.imageView)
        iv.background = ad
        ad.start()
    }
}