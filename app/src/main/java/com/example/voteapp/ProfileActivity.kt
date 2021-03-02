package com.example.voteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.example.voteapp.adapter.ProfileTabAdapter
import com.google.android.material.tabs.TabLayout
import com.mikhaellopez.circularimageview.CircularImageView

class ProfileActivity : AppCompatActivity() {
    private var oldScrollYPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val viewPager: ViewPager = findViewById(R.id.viewPager_profile)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_profile)
        tabLayout.addTab(tabLayout.newTab().setText("Bejegyzések"))
        tabLayout.addTab(tabLayout.newTab().setText("Szavazások"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val sectionsPagerAdapter =
            ProfileTabAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = sectionsPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        val constraintLayout = findViewById<ConstraintLayout>(R.id.contraint_layout_profile)
        constraintLayout.layoutTransition.setDuration(500)

    }
}