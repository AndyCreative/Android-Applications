package com.ankit.tab_layout_demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(fragmnetManager : FragmentManager,lifecycle : Lifecycle) :FragmentStateAdapter(fragmnetManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return FormFragment()
            1-> return DetailsFragment()
            else -> return FormFragment()
        }
    }
}