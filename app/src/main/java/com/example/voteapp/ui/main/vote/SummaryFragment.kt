package com.example.voteapp.ui.main.vote

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.voteapp.R
import com.example.voteapp.dialogs.VoteDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SummaryFragment : Fragment() {
    private lateinit var root: View
    private lateinit var scrollView: ScrollView
    private var oldScrollYPosition = 0
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_plan, container, false)

        fab = root.findViewById(R.id.fab_summary)
        fab.setOnClickListener{openVoteDialog()}
        scrollView = root.findViewById(R.id.sv_summaryScrollView)
        scrollView.viewTreeObserver
            .addOnScrollChangedListener {
                if (scrollView.scrollY > oldScrollYPosition) {
                    fab.hide()
                } else if (scrollView.scrollY < oldScrollYPosition || scrollView.scrollY <= 0) {
                    fab.show()
                }
                oldScrollYPosition = scrollView.scrollY
            }

        return root
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            if(activity != null){
                val twFragmentName = activity!!.findViewById<TextView>(R.id.tw_fragment_name)
                twFragmentName.text = "Összefoglalás"
            }
        }
    }


    override fun onStart() {
        super.onStart()
        val twFragmentName = activity!!.findViewById<TextView>(R.id.tw_fragment_name)
        twFragmentName.text = "Összefoglaló"

    }

    private fun openVoteDialog() {
        fragmentManager?.let { VoteDialogFragment.newInstance(("Támogattom"), "Nem támogatom").show(it, VoteDialogFragment.TAG) }

    }

}
