package com.example.voteapp.ui.main.startView

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.R
import com.example.voteapp.adapter.EndedVotesAdapter
import com.example.voteapp.data.MyLocation
import com.example.voteapp.data.User
import com.example.voteapp.data.Vote
import kotlinx.android.synthetic.main.fragment_vote_history.view.*
import java.time.LocalDateTime

class VoteHistoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vote_history, container, false)
        initView(view)
        return  view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initView(view: View?) {

        val vote1 = Vote("drawable/menhely_k_p", MyLocation(MyLocation.Areas.CITY, "Pécs"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            false, LocalDateTime.of(2021,3,5,11,24), User("drawable/man_icon","Nagy Jóska", "polgármester"), "Állatmenhely építés"
        );

        val vote5 = Vote("drawable/ut", MyLocation(MyLocation.Areas.SHIRE,"Baranya"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            false, LocalDateTime.of(2022,3,5,11,24), User("drawable/man_icon","Kis Béla", "képviselő"), "Útfelújítás"
        );

        val vote2 = Vote("drawable/kerites", MyLocation(MyLocation.Areas.COUNTRY,"Országos"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            false, LocalDateTime.of(2021,6,10,11,24), User("drawable/man_icon","Viczke Attila", "miniszter"), "Határ menti kerítés"
        );

        val vote3 = Vote("drawable/csend", MyLocation(MyLocation.Areas.CITY,"Budapest"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            false, LocalDateTime.of(2021,1,20,11,24), User("drawable/man_icon","Halas Lajos", "főpolgármester"), "Csendrendelet"
        );

        val vote4 = Vote("drawable/vakcina", MyLocation(MyLocation.Areas.COUNTRY,"Országos"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            false, LocalDateTime.of(2021,3,5,11,24), User("drawable/man_icon","KDNP", "párt"), "Oltási hajlandóság"
        );

        val voteList = ArrayList<Vote>()
        voteList.add(vote1)
        voteList.add(vote2)
        voteList.add(vote3)
        voteList.add(vote4)
        voteList.add(vote5)
        val adapter = EndedVotesAdapter(voteList)
        val recyler = view!!.findViewById<RecyclerView>(R.id.ended_votes_recycler)
        recyler.adapter = adapter
        recyler.layoutManager = LinearLayoutManager(context)

    }


}
