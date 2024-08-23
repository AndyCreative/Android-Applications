package com.example.contactcontentprovider

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat

class CallContentProvider : AppCompatActivity() {
    var cols = arrayOf(CallLog.Calls.NUMBER, CallLog.Calls.DURATION, CallLog.Calls._ID)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_content_provider)
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CALL_LOG),113)
        }
        else{
            readCallLog()
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==113 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            readCallLog()
        }
    }
    private fun readCallLog() {
        var rs = contentResolver.query(CallLog.Calls.CONTENT_URI,cols,null,null,null)
        var lv = findViewById<ListView>(R.id.listview1)
        var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,cols,
            intArrayOf(android.R.id.text1,android.R.id.text2),0)
        lv.adapter = adapter
    }
}