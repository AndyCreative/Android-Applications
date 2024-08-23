package com.ankit.demo_frmbyfrm

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ad = AnimationDrawable()

        var f1 = resources.getDrawable(R.drawable.frame1,null)
        var f2 = resources.getDrawable(R.drawable.frame2,null)

        ad.addFrame(f1,1000)
        ad.addFrame(f2,1000)

        var iv = findViewById<ImageView>(R.id.imageView)
        iv.background = ad
        ad.start()
    }
}