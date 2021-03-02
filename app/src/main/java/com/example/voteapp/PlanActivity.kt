package com.example.voteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.example.voteapp.adapter.MyVoteTabAdapter
import kotlinx.android.synthetic.main.activity_plan3.*

class PlanActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    lateinit var plan_right: ImageButton
    lateinit var plan_left: ImageButton
    lateinit var plan_summary: Button
    var num_of_pages = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan3)
        viewPager = findViewById(R.id.viewPager_plan)

        val adapter = MyVoteTabAdapter(supportFragmentManager, num_of_pages)
        viewPager.adapter = adapter

        plan_right = findViewById(R.id.plan_right)
        plan_right.setOnClickListener{
            viewPager.setCurrentItem(adapter.scrollRight(viewPager.currentItem),true)
        }

        plan_left = findViewById(R.id.plan_left)
        plan_left.setOnClickListener{
            viewPager.setCurrentItem(adapter.scrollLeft(viewPager.currentItem),true)
        }

        plan_summary = findViewById(R.id.plan_summary)
        plan_summary.setOnClickListener{
            viewPager.setCurrentItem(0,true)
        }
    }}
