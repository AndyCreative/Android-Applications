package com.ankit.tab_layout_demo

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRvAdapter : RecyclerView.Adapter<MyRvAdapter.MyHolder>() {

    inner class MyHolder(view : View) : RecyclerView.ViewHolder(view){
        var cvname : TextView
        var cvcollege : TextView
        var cvsem : TextView
        var cvphone : TextView

        init {
            cvname = view.findViewById(R.id.cvname)
            cvcollege = view.findViewById(R.id.cvcollege)
            cvsem = view.findViewById(R.id.cvsem)
            cvphone = view.findViewById(R.id.cvphone)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRvAdapter.MyHolder {

    }

    override fun onBindViewHolder(holder: MyRvAdapter.MyHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return
    }
}