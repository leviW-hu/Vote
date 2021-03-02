package com.example.voteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.R
import kotlinx.android.synthetic.main.positive_list_item.view.*

class PositiveElementsAdapter: RecyclerView.Adapter<PositiveElementsAdapter.ViewHolder> {

    private val context: Context
    private val items: List<String>

    constructor(context: Context, items: List<String>){
        this.context = context
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.positive_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvPositive.text = items[position]
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvPositive : TextView = itemView.tvPositive
    }

}