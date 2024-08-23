package com.example.contact_content_provider

import android.Manifest
import android.content.ContentProvider
import android.content.ContentResolver
import android.content.ContentUris
import android.content.ContentValues
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    var cols = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
    ContactsContract.CommonDataKinds.Phone._ID)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.READ_CONTACTS),111)
        }
        else{
            readContacts()
        }

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_CONTACTS)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.WRITE_CONTACTS),112)
        }
        else{
            writeContacts()
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            readContacts()
        }

        if(requestCode==112 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            writeContacts()
        }
    }

    private fun readContacts() {
        var rs = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        var adapter = SimpleCursorAdapter(applicationContext,
        android.R.layout.simple_list_item_2,
        rs,
        cols,
        intArrayOf(android.R.id.text1,android.R.id.text2),0)

        var lv = findViewById<ListView>(R.id.listview)
        lv.adapter = adapter

        var sv = findViewById<SearchView>(R.id.searchView)
        sv.queryHint = "Search Among ${rs?.count} Contact"
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                rs = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols,
                    "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    arrayOf("%$p0%"),ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                adapter.changeCursor(rs)
                return false
            }
        })
    }
    
    private fun writeContacts() {
        var cv = ContentValues()
        var rawUri = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI,cv)
        var rawContentId = ContentUris.parseId(rawUri!!)

        cv.put(ContactsContract.Data.RAW_CONTACT_ID,rawContentId)
        cv.put(ContactsContract.Data.MIMETYPE,
                ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
        cv.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,"TEST")
        contentResolver.insert(ContactsContract.Data.CONTENT_URI,cv)

        cv.put(ContactsContract.Data.RAW_CONTACT_ID,rawContentId)
        cv.put(ContactsContract.Data.MIMETYPE,
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
        cv.put(ContactsContract.CommonDataKinds.Phone.NUMBER,9900990099)
        contentResolver.insert(ContactsContract.Data.CONTENT_URI,cv)
    }
}