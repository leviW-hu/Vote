package com.example.voteapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.voteapp.ui.main.startView.ActiveVotesFragment
import com.example.voteapp.ui.main.startView.FeedFragment
import com.example.voteapp.ui.main.startView.StartingFragment
import com.example.voteapp.ui.main.startView.VoteHistoryFragment
import com.google.android.material.tabs.TabLayout

@Suppress("DEPRECATION")
internal class MainTabAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var tabs: TabLayout
) :

    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FeedFragment()
            }
            1 -> {
                ActiveVotesFragment()
            }
            2 -> {
                VoteHistoryFragment()
            }
            3 -> {
                StartingFragment()

            }
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
