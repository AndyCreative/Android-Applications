package com.example.audio_video_camera

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnaudio : Button
    lateinit var btnstop : Button
    lateinit var btnaudio1 : Button
    lateinit var btnstop1 : Button
    lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnaudio = findViewById(R.id.btnaudio)
        btnstop = findViewById(R.id.btnstop)
        btnaudio1 = findViewById(R.id.btnaudio1)
        btnstop1 = findViewById(R.id.btnstop1)

        //Code of playing audio offline

        btnaudio.setOnClickListener {
            mp = MediaPlayer.create(this,R.raw.motiveranachowkma)
            mp.start()
        }

        btnstop.setOnClickListener {
            mp.stop()
        }

        //Code of playing audio online

        btnaudio1.setOnClickListener {
            mp = MediaPlayer()
            mp.setDataSource(this,Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"))
            mp.prepare()
            mp.start()
        }

        btnstop1.setOnClickListener {
            mp.stop()
        }

    }
}