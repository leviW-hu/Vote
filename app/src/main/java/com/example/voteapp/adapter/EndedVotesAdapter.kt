package com.example.voteapp.adapter

import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.R
import com.example.voteapp.VoteHistoryActivity
import com.example.voteapp.data.Vote
import kotlinx.android.synthetic.main.ended_vote_item.view.*


class EndedVotesAdapter : RecyclerView.Adapter<EndedVotesAdapter.ViewHolder> {


    var list: ArrayList<Vote>


    constructor(list: ArrayList<Vote>){
        this.list = list

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ended_vote_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    //    holder.userName.text = list[position].creator.name
        holder.voteText.text = list[position].text
        holder.deadline.text = list[position].monthAndDay
        holder.voteTitle.text = list[position].title
        holder.voteLocation.text = list[position].location.name
        holder.voteImg.setImageResource(holder.context.resources.getIdentifier(list[position].imgPath,"drawable",holder.context.packageName))

        holder.layout.setOnClickListener{
            val intent = Intent(holder.context, VoteHistoryActivity::class.java)
            holder.context.startActivity(intent)
        }
        setBgColor(holder,position)
    }

    private fun setBgColor(holder: ViewHolder, position: Int) {
 /*       when(list[position].location.type){
            MyLocation.Areas.CITY ->  {
                holder.voteBg.setBackgroundColor( Color.parseColor("#4CAF50"))
                holder.voteLocation.setBackgroundColor(Color.parseColor("#4CAF50"))
            }
            MyLocation.Areas.SHIRE ->  {
                holder.voteBg.setBackgroundColor( Color.parseColor("#FFAB47BC"))
                holder.voteLocation.setBackgroundColor(Color.parseColor("#FFAB47BC"))
            }
            MyLocation.Areas.COUNTRY ->{
                holder.voteBg.setBackgroundColor( Color.parseColor("#FF5722"))
                holder.voteLocation.setBackgroundColor(Color.parseColor("#FF5722"))
            }
        }
 */   }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // val userName: TextView = itemView.user_name
        val voteText: TextView = itemView.vote_text1
        val deadline: TextView = itemView.vote_deadline1
        val voteTitle: TextView = itemView.vote_title1
        val voteLocation: TextView = itemView.vote_location1
        //    val voteBg: LinearLayout = itemView.vote_bg
        val voteImg: ImageView = itemView.vote_image1
        val context = itemView.context
        val layout = itemView.ll_ended_vote_layout
    }


}
