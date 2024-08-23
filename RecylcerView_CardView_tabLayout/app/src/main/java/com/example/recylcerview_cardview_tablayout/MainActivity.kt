package com.example.recylcerview_cardview_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var data = arrayOf("Photos","Faculty")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tl = findViewById<TabLayout>(R.id.tabLayout)
        var pager = findViewById<ViewPager2>(R.id.viewPager2)

        pager.adapter = MyAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tl,pager){
                tab,position ->
            tab.text = data[position]
        }.attach()
    }
}