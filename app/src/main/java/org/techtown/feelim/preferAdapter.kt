package org.techtown.feelim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class preferAdapter(val movieList1:ArrayList<preference>) : RecyclerView.Adapter<preferAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): preferAdapter.CustomViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)//listitem을 끌고와서 어댑터에 붙여줌
        return CustomViewHolder(view)//뷰연동
    }

    override fun onBindViewHolder(holder: preferAdapter.CustomViewHolder, position: Int) {
       holder.poster1.setImageResource(movieList1.get(position).poster1)
        holder.name1.text=movieList1.get(position).name1
    }

    override fun getItemCount(): Int {
        return movieList1.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val poster1=itemView.findViewById<ImageView>(R.id.posterView)
        val name1=itemView.findViewById<TextView>(R.id.nameView)
    }

}