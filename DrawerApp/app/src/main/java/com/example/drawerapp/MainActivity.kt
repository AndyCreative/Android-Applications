package com.example.drawerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.frame,Unit1()).commit()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var drawer = findViewById<DrawerLayout>(R.id.drawer)
        toggle = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        var units = arrayOf("Unit-1","Unit-2","Unit-3","Unit-4","Unit-5")
        var adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,units)
        var lv = findViewById<ListView>(R.id.listView1)
        lv.adapter = adapter

        lv.setOnItemClickListener { adapterView, view, i, l ->
            drawer.closeDrawers()
            when(i){
                0 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,Unit1()).commit()
                }
                1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,Unit2()).commit()
                }
                2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,Unit3()).commit()
                }
                3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,Unit4()).commit()
                }
                4 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame,Unit5()).commit()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}