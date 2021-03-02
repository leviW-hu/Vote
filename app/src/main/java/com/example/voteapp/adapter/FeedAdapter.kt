package com.example.voteapp.adapter
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.R
import com.example.voteapp.data.Feed
import kotlinx.android.synthetic.main.feed_item.view.*


class FeedAdapter : RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private val context: Context
    private var list = ArrayList<Feed>()

    constructor(context: Context, list: ArrayList<Feed>){
        this.context = context
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return list.size;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.feedAuthor.text = list[position].author
        holder.feedDate.text = list[position].timeSince()
        holder.feedText.text = list[position].text
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val feedAuthor = itemView.feed_author
        val feedDate = itemView.feed_date
        val feedText = itemView.feed_text

    }

}
