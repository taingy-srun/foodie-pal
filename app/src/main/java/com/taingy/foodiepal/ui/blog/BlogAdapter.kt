package com.taingy.foodiepal.ui.blog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taingy.foodiepal.R


class BlogAdapter(private val blogs: List<Blog>) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return blogs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val blog = blogs[position]

        holder.title.text = blog.title
        holder.description.text = blog.description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
    }
}