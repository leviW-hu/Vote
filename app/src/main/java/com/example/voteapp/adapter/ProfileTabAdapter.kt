package com.example.voteapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.voteapp.ui.main.profile.ProfileFeedFragment
import com.example.voteapp.ui.main.profile.ProfileVotesFragment
import com.example.voteapp.ui.main.startView.ActiveVotesFragment
import com.example.voteapp.ui.main.startView.StartingFragment

class ProfileTabAdapter(var context: Context,
                        fm: FragmentManager,
                        var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ProfileFeedFragment()
            }
            1 -> {
                ProfileVotesFragment()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}
