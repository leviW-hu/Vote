package com.example.voteapp.ui.main.startView

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.voteapp.PlanActivity
import com.example.voteapp.ProfileActivity
import com.example.voteapp.R
import com.example.voteapp.VoteHistoryActivity
import com.mikhaellopez.circularimageview.CircularImageView

class StartingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_starting, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        val ll_firstVoteing = view.findViewById<LinearLayout>(R.id.ll_firstVoteing)
        ll_firstVoteing.setOnClickListener{ openVote()}

        val ll_histVote = view.findViewById<LinearLayout>(R.id.ll_histVote)
        ll_histVote.setOnClickListener{openVoteHist()}

        val img_profile2 = view.findViewById<CircularImageView>(R.id.img_profile2)
        img_profile2.setOnClickListener{openProfile()}


    }

    private fun openProfile() {
        val intent = Intent(context,ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun openVoteHist() {
        val intent = Intent(context,VoteHistoryActivity::class.java)
        startActivity(intent)
    }

    private fun openVote() {
        val intent: Intent = Intent(context,PlanActivity::class.java)
        startActivity(intent)
    }
}
