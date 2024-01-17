package com.myappf.pricecomparison

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(private val exat: List<items>):RecyclerView.Adapter<adapter.viewghold>() {
    class viewghold(tih:View):RecyclerView.ViewHolder(tih){
        val txtx = tih.findViewById<TextView>(R.id.tex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewghold {
       val tea = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return viewghold(tea)
    }

    override fun onBindViewHolder(holder: viewghold, position: Int) {
        val ctem = exat[position]
        holder.txtx.text = ctem.strin
    }

    override fun getItemCount() = exat.size


}