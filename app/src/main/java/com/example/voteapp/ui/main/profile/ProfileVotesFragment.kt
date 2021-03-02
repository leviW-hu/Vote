package com.example.voteapp.ui.main.profile
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voteapp.R
import com.example.voteapp.adapter.ActiveVotesAdapter
import com.example.voteapp.data.MyLocation
import com.example.voteapp.data.User
import com.example.voteapp.data.Vote
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_active_votes.view.*
import java.time.LocalDateTime

class ProfileVotesFragment : Fragment() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.frofile_votes_fragment, container, false)
        initView(view)
        return view
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initView(view: View?) {

        val vote1 = Vote("drawable/dog_icon", MyLocation(MyLocation.Areas.CITY, "Pécs"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            true, LocalDateTime.of(2021,3,5,11,24), User("drawable/man_icon","Nagy Jóska", "polgármester"), "Állatmenhely építés"
        );

        val vote5 = Vote("drawable/ut", MyLocation(MyLocation.Areas.SHIRE,"Baranya"), "Nulla eget luctus nisi. Proin eu massa vel libero convallis accumsan a eget erat. Nulla ut convallis sapien. Cras a scelerisque neque. Integer sit amet tempus urna. Aliquam egestas risus mauris, vel tristique nulla tristique ut. In venenatis dictum est a cursus. Praesent vel leo sit amet mauris porttitor gravida. Vestibulum gravida sem tincidunt, dignissim velit sed, elementum nibh. Donec lacinia velit leo, eget dictum risus maximus nec. Curabitur sapien sapien, pulvinar sed posuere eget, bibendum tempor nunc",
            true, LocalDateTime.of(2022,3,5,11,24), User("drawable/man_icon","Kis Béla", "képviselő"), "Útfelújítás"
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
        view!!.recycler_active_votes.adapter = ActiveVotesAdapter(voteList)
        view!!.recycler_active_votes.layoutManager = LinearLayoutManager(context)


        val header_big = activity!!.findViewById<ConstraintLayout>(R.id.header_big)
        val header_small = activity!!.findViewById<LinearLayout>(R.id.header_small)
        val tabLayout_profile = activity!!.findViewById<TabLayout>(R.id.tabLayout_profile)
        val constraintLayout = activity!!.findViewById<ConstraintLayout>(R.id.contraint_layout_profile)

        header_small.setOnClickListener{
            header_big.visibility = View.VISIBLE
            header_small.visibility = View.GONE

            var constraintSet = ConstraintSet()
            constraintSet.clone(constraintLayout)
            constraintSet.connect(R.id.tabLayout_profile, ConstraintSet.TOP, R.id.header_big, ConstraintSet.BOTTOM )
            constraintSet.applyTo(constraintLayout)

        }

        view!!.recycler_active_votes.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 ) {
                    header_big.visibility = View.GONE
                    header_small.visibility = View.VISIBLE

                    var constraintSet = ConstraintSet()
                    constraintSet.clone(constraintLayout)
                    constraintSet.connect(R.id.tabLayout_profile, ConstraintSet.TOP, R.id.header_small, ConstraintSet.BOTTOM )
                    constraintSet.applyTo(constraintLayout)

                }
            }



        })

    }



}
