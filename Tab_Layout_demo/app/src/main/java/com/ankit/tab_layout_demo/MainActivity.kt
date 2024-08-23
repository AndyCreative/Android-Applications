package com.ankit.tab_layout_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var data = arrayOf("Form","Details")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tl = findViewById<TabLayout>(R.id.tabLayout)
        var pager = findViewById<ViewPager2>(R.id.viewPager)

        pager.adapter = MyAdapter(supportFragmentManager,lifecycle)
        TabLayoutMediator(tl,pager){
            tab,position->tab.text = data[position]
        }.attach()
    }
}