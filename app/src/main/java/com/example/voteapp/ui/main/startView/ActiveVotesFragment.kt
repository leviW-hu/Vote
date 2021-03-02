package com.example.voteapp.ui.main.startView

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.voteapp.PlanActivity
import com.example.voteapp.R
import com.example.voteapp.adapter.ActiveVotesAdapter
import com.example.voteapp.data.User
import com.example.voteapp.data.Vote
import com.example.voteapp.data.MyLocation
import kotlinx.android.synthetic.main.fragment_active_votes.view.*
import java.time.LocalDateTime

class ActiveVotesFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_active_votes, container, false)
        initView(view)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initView(view: View) {
        val vote1 = Vote("drawable/menhely_k_p", MyLocation(MyLocation.Areas.CITY, "Pécs"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
        true, LocalDateTime.of(2021,3,5,11,24), User("drawable/man_icon","Nagy Jóska", "polgármester"), "Állatmenhely építés"
        );

        val vote5 = Vote("drawable/misina_cover", MyLocation(MyLocation.Areas.SHIRE,"Baranya"), "A lakosságot megszólító rendhagyó önkormányzati pályázatra konkrét ötleteket vártak a pécsiektől a TV-torony környékének hasznosítására. Összesen 35 pályamű érkezett a szeptember végi határidőre, ezek közül egy nyolcfős szakmai zsűri választotta ki a három megvalósítható, szavazásra bocsájtott koncepciótervet. ",
            true, LocalDateTime.of(2012,3,5,11,24), User("drawable/man_icon","Kis Béla", "képviselő"), "Misina ötletbörze"
        );

        val vote2 = Vote("drawable/kerites", MyLocation(MyLocation.Areas.COUNTRY,"Országos"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            true, LocalDateTime.of(2021,6,10,11,24), User("drawable/man_icon","Viczke Attila", "miniszter"), "Határ menti kerítés"
        );

        val vote3 = Vote("drawable/csend", MyLocation(MyLocation.Areas.CITY,"Budapest"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            true, LocalDateTime.of(2021,1,20,11,24), User("drawable/man_icon","Halas Lajos", "főpolgármester"), "Csendrendelet"
        );

        val vote4 = Vote("drawable/vakcina", MyLocation(MyLocation.Areas.COUNTRY,"Országos"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            true, LocalDateTime.of(2021,3,5,11,24), User("drawable/man_icon","KDNP", "párt"), "Oltási hajlandóság"
        );


        val voteList = ArrayList<Vote>()
        voteList.add(vote1)
        voteList.add(vote2)
        voteList.add(vote3)
        voteList.add(vote4)
        voteList.add(vote5)
        view.recycler_active_votes.adapter = ActiveVotesAdapter(voteList)
        view.recycler_active_votes.layoutManager = LinearLayoutManager(context)

    }

    private fun openVote() {
        val intent: Intent = Intent(context,PlanActivity::class.java)
        startActivity(intent)
    }
}
