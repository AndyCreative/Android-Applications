package com.ankit.recordaudiodemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.media.MediaParser
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var mr : MediaRecorder
    lateinit var playBU : Button
    lateinit var stopBU : Button
    lateinit var startBU : Button


    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        playBU = findViewById(R.id.palybu)
        stopBU = findViewById(R.id.stopbu)
        startBU = findViewById(R.id.startbu)
        var path = Environment.getExternalStorageDirectory()
            .toString()+"/myrec.3gp"


        if(Build.VERSION.SDK_INT>=31)
            mr = MediaRecorder(this)
        else
            mr = MediaRecorder()

        playBU.isEnabled = false
        stopBU.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO,Manifest.permission.WRITE_EXTERNAL_STORAGE),111)
        }
        startBU.isEnabled = true

        //Start Recording
        startBU.setOnClickListener {
            mr.setAudioSource(MediaRecorder.AudioSource.MIC)
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            mr.setOutputFile(path)
            mr.prepare()
            mr.start()
            stopBU.isEnabled = true
            startBU.isEnabled = false
        }

        //Stop Recording
        stopBU.setOnClickListener {
            mr.stop()
            startBU.isEnabled = true
            stopBU.isEnabled = false
            playBU.isEnabled = true
        }

        //Play Recording
        playBU.setOnClickListener {
            var mp = MediaPlayer()
            mp.setDataSource(path)
            mp.prepare()
            mp.start()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            startBU.isEnabled = true
    }
}