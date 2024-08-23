package com.example.location_geocoding

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.*
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

class ReverseGeoLocation : AppCompatActivity() {
    lateinit var lm : LocationManager
    lateinit var loc : Location
    lateinit var tv2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse_geo_location)

        tv2 = findViewById(R.id.textView3)

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),111)
        }

        lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
        var ll = object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                reverseGeocode(p0)
            }

        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,100,100.2f,ll)
    }

    private fun reverseGeocode(loc: Location?) {
        var gc = Geocoder(this,Locale.getDefault())
        var addresses = gc.getFromLocation(loc!!.latitude,loc.longitude,2)
        var address = addresses.get(0)
        tv2.setText("${address.getAddressLine(0)}\n${address.locality}")
    }


}