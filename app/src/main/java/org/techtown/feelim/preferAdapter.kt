package org.techtown.feelim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class preferAdapter(val movieList1:ArrayList<preference>) : RecyclerView.Adapter<preferAdapter.CustomViewHolder>(){
    //레이아웃 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): preferAdapter.CustomViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)//listitem을 끌고와서 어댑터에 붙여줌
        return CustomViewHolder(view)//뷰연동
    }
    //position에 해당하는 데이터 뷰홀더에 바인딩
    override fun onBindViewHolder(holder: preferAdapter.CustomViewHolder, position: Int) {
       holder.poster1.setImageResource(movieList1.get(position).poster1)
        holder.name1.text=movieList1.get(position).name1
        holder.name2.text=movieList1.get(position).name2
        holder.name3.text=movieList1.get(position).name3
        holder.name4.text=movieList1.get(position).name4
    }
    //아이템 개수 리턴
    override fun getItemCount(): Int {
        return movieList1.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster1=itemView.findViewById<ImageView>(R.id.posterView)
        val name1=itemView.findViewById<TextView>(R.id.nameView)
        val name2=itemView.findViewById<TextView>(R.id.countryView)
        val name3=itemView.findViewById<TextView>(R.id.timeView)
        val name4=itemView.findViewById<TextView>(R.id.openView)
    }

}