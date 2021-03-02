package com.example.voteapp.ui.main.startView

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.PlanActivity
import com.example.voteapp.R
import com.example.voteapp.adapter.FeedAdapter
import com.example.voteapp.data.Feed
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class FeedFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        initView(view)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initView(view: View) {
        val recycler_feed = view.findViewById<RecyclerView>(R.id.recycler_feed)
        val feed1 = Feed("Nagy Géza", LocalDateTime.of(2021,1,1,18,12,31),"Nulla faucibus justo et nisl varius, sit amet placerat metus imperdiet. Vivamus eget orci vel dolor maximus tristique eu in nisl. Duis sed lectus feugiat, feugiat justo et, fermentum urna. Integer sit amet dolor sollicitudin, fringilla nulla a, dictum urna. Fusce non diam ut nibh laoreet dignissim. Aliquam turpis lorem, hendrerit ut nulla ac, vestibulum imperdiet est. Etiam a pharetra purus, ac placerat augue. Vivamus cursus diam at mi pharetra ultrices. Nullam imperdiet dignissim velit, nec dapibus sapien vestibulum fringilla. Aliquam lacinia erat in est suscipit rhoncus. Aliquam bibendum urna egestas dolor porta, id dignissim justo commodo. Vestibulum eget cursus ex, at elementum turpis. Suspendisse scelerisque congue magna, laoreet ultrices felis pulvinar quis. Vivamus nulla augue, egestas nec ante sit amet, dignissim eleifend tortor. Nullam interdum sollicitudin ante, posuere consectetur felis finibus in. Morbi mollis vulputate ullamcorper.\n" +
                "\n")
        val feed2 = Feed("Kis Pista", LocalDateTime.of(2020,3,20,10,15,54),"Maecenas mattis quis arcu at vulputate. In purus mauris, suscipit sit amet nunc sit amet, hendrerit dignissim ipsum. Sed eu quam erat. Aenean finibus eros dui, at convallis enim elementum sit amet. Aenean et metus sit amet ante consectetur rhoncus. Donec ultricies dui vel sem scelerisque, eget interdum urna egestas. Proin sit amet ipsum eget elit pharetra vehicula. In finibus sollicitudin dolor id auctor. Morbi cursus viverra tortor ac auctor. Vivamus eu arcu vitae eros cursus maximus in sit amet ex. Suspendisse scelerisque ligula quis turpis ornare fringilla. Integer ac eleifend risus.")
        val feed3 = Feed("Kereszti János", LocalDateTime.of(2015,3,20,10,15,54), "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam ut elit libero. Donec sem mauris, congue et consequat nec, imperdiet et ex. Pellentesque ac magna sed purus gravida pellentesque. Nullam mattis nisi fermentum ligula luctus semper. Maecenas mattis ante pulvinar commodo sollicitudin. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n" )

        val feedList = ArrayList<Feed>()
        feedList.add(feed1)
        feedList.add(feed2)
        feedList.add(feed3)
        recycler_feed.adapter = FeedAdapter(context!!,feedList)
        recycler_feed.layoutManager = LinearLayoutManager(context)

    }

    private fun openVote() {
        val intent: Intent = Intent(context,PlanActivity::class.java)
        startActivity(intent)
    }
}
