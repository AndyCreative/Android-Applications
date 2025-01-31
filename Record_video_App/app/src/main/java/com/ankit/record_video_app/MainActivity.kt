package com.ankit.record_video_app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.isEnabled = false
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),111)
        else
            button.isEnabled = true

        button.setOnClickListener {
            var i = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
            startActivityForResult(i,101)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101){
            videoView.setVideoURI(data?.data)
            videoView.start()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            button.isEnabled = true
    }
}