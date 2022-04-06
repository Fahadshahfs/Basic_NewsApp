package com.simplenewsapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


// Adapter for RecyclerView

class ListAdapter(private val listener: listitemclicked) : RecyclerView.Adapter<ListViewholder>() {

    private val itemslist: ArrayList<NewsData> = ArrayList(
    )

    // onCreateViewHolder Called by RecyclerView to display the data at the specified position
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewholder {

        val itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.items_list, parent, false)
        val viewHolder = ListViewholder(itemview)

        itemview.setOnClickListener()
        {
            listener.onitemclicked(itemslist[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder

    }

    // onBindViewHolder binding data in holder

    override fun onBindViewHolder(holder: ListViewholder, position: Int) {

        val currentitem = itemslist[position]
        holder.titles.text = currentitem.title
        Glide.with(holder.img1.context).load(currentitem.urlToImage).into(holder.img1)


    }

    // getItemCount for total numbers of items in List or RecyclerView

    override fun getItemCount(): Int {
        return itemslist.size


    }

    @SuppressLint("NotifyDataSetChanged")
    fun newsUpdate(newsUpdate: ArrayList<NewsData>) {

        itemslist.clear()
        itemslist.addAll(newsUpdate)

        notifyDataSetChanged()

    }
}
// ViewHolder describes an item view and metadata about its place within the RecyclerView

class ListViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titles: TextView = itemView.findViewById(R.id.titletext)
    val img1: ImageView = itemView.findViewById(R.id.imgpost)

}

interface listitemclicked {
    fun onitemclicked(item: NewsData)
}