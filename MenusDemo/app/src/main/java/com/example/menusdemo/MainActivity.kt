package com.example.menusdemo

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById<TextView>(R.id.textview)
        registerForContextMenu(tv)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Choose Color")
        menu?.add(102,1111,1,"RED")
        menu?.add(102,1112,2,"GREEN")
        menu?.add(102,1113,3,"BLUE")
        menu?.add(102,1114,4,"BLACK")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1111->{tv.setTextColor(Color.RED)}
            1112->{tv.setTextColor(Color.GREEN)}
            1113->{tv.setTextColor(Color.BLUE)}
            1114->{tv.setTextColor(Color.BLACK)}
        }

        return super.onContextItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(101,1001,1,"New Group")
        menu?.add(101,1002,2,"New Broadcast")
        menu?.add(101,1003,3,"Linked Devices")
        menu?.add(101,1004,4,"Starred Messeges")
        menu?.add(101,1005,5,"Payments")
        menu?.add(101,1006,6,"Settings")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1001->{ Toast.makeText(applicationContext,"New Group is Clicked",Toast.LENGTH_LONG).show()}
            1002->{ Toast.makeText(applicationContext,"New Broadcast is Clicked",Toast.LENGTH_LONG).show()}
            1003->{ /*tv.setTextSize(40f)*/ tv.textSize=40f}
            1006->{startActivity(Intent(applicationContext,SettingActivity::class.java))}
        }

        return super.onOptionsItemSelected(item)
    }


}