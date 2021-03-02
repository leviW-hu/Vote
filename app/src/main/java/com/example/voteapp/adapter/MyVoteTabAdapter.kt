package com.example.voteapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.voteapp.ui.main.vote.PlanAFragment
import com.example.voteapp.ui.main.vote.PlanBFragment
import com.example.voteapp.ui.main.vote.PlanCFragment
import com.example.voteapp.ui.main.vote.SummaryFragment

@Suppress("DEPRECATION")
internal class MyVoteTabAdapter(
    fm: FragmentManager,
    var totalTabs: Int
) :

    FragmentPagerAdapter(fm) {
    fun scrollRight(pager_position: Int): Int {
        if(pager_position == (totalTabs - 1)){
            return 0
        }
        else {
            return (pager_position + 1)
        }
    }

    fun scrollLeft(pager_position: Int): Int{
        if(pager_position == 0){
            return totalTabs
        }
        else {
            return (pager_position - 1)
        }
    }


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SummaryFragment()
            }
            1 -> {
                PlanAFragment()
            }
            2 -> {
                PlanBFragment()
            }
            3 -> {
                PlanCFragment()
            }
            else -> SummaryFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
