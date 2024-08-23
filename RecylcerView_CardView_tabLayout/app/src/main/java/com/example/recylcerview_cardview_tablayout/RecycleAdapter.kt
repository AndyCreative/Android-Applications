package com.example.recylcerview_cardview_tablayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecycleAdapter : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    val fname = arrayOf("Dr.Minal Shukla.","Dr.Hetal Thaker","Dr.Ankita Faldu","Dr.Sumita Tank","DR.Nishita Gohel" )
    val desg = arrayOf("Associate Professor","Associate Professor","Associate Professor","Associate Professor","Associate Professor")
    val pics = intArrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e)
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var image :ImageView
        var fname : TextView
        var desg : TextView
        init {
            image = view.findViewById(R.id.ImageView)
            fname = itemView.findViewById(R.id.TextView1)
            desg = itemView.findViewById(R.id.TextView2)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapter.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecycleAdapter.ViewHolder, position: Int) {
        holder.fname.text = fname[position]
        holder.desg.text = desg[position]
        holder.image.setImageResource(pics[position])
    }

    override fun getItemCount(): Int {
        return fname.size
    }

}