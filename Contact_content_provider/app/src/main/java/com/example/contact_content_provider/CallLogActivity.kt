package com.example.contact_content_provider

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.telecom.Call
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat

class CallLogActivity : AppCompatActivity() {
    var cols = arrayOf(CallLog.Calls.NUMBER,
                        CallLog.Calls.DURATION,
                        CallLog.Calls._ID)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_log)

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CALL_LOG),113)
        }
        else{
            readCallLog()
        }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_CALL_LOG)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_CALL_LOG),114)
        }
        else{
            writeCallLog()
        }
    }

    private fun writeCallLog() {
        var cv = ContentValues()
        cv.put(CallLog.Calls.NUMBER,11111111111)
        cv.put(CallLog.Calls.DURATION,2333)
        var a = contentResolver.insert(CallLog.Calls.CONTENT_URI,cv)

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
        if(requestCode==114 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            writeCallLog()
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