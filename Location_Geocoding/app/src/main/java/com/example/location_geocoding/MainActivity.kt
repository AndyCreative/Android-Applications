package com.example.location_geocoding

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var ed :EditText
    lateinit var bu :Button
    lateinit var tv2 :TextView
    lateinit var city : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed = findViewById<EditText>(R.id.edittext)
        bu = findViewById<Button>(R.id.button)
        tv2 = findViewById(R.id.textView2)
        city = ""

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),111)
        }
        else{
            bu.setOnClickListener {
                var city = ed.text.toString()
                forwardGeoloaction(city)
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED){

        }
    }

    private fun forwardGeoloaction(city: String) {
        var gc = Geocoder(this, Locale.getDefault())
        var addresses = gc.getFromLocationName(city,2)
        var address = addresses.get(0)
        tv2.setText("${address.longitude}\n${address.latitude}\n${address.locality}")
    }
}