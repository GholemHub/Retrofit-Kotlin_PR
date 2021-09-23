package com.example.getpost_retrofit_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getpost_retrofit_pr.R
import com.example.getpost_retrofit_pr.model.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private var myList = emptyList<Post>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var userId_tv: TextView
        var id_tv: TextView
        var title_tv: TextView
        var body_tv: TextView

        init {
          userId_tv = itemView.findViewById(R.id.userId_tv)
          id_tv = itemView.findViewById(R.id.id_tv)
          title_tv = itemView.findViewById(R.id.title_tv)
          body_tv = itemView.findViewById(R.id.body_tv)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userId_tv.text = myList[position].userId.toString()
        holder.id_tv.text = myList[position].id.toString()
        holder.title_tv.text = myList[position].title
        holder.body_tv.text = myList[position].body
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}