package com.example.voteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_vote_history.*

class VoteHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote_history)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab:TabLayout.Tab) {
                when (tab.position){
                    0 -> {iv_graph.setImageResource(R.drawable.result1)}
                    1 -> {iv_graph.setImageResource(R.drawable.chart1)}
                }
            }
        })

}
}
