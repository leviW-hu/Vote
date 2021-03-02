package com.example.voteapp.ui.main.vote

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.voteapp.FingerPrintActivity
import com.example.voteapp.R


class PlanAFragment : Fragment() {

  //  lateinit var btnVote: Button
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_option1, container, false)

   //        btnVote.setOnClickListener { clickVoteBtn() }

        return root
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            if(activity != null){
                val twFragmentName = activity!!.findViewById<TextView>(R.id.tw_fragment_name)
                twFragmentName.text = "Aktív Misina"
            }
        }
    }
    override fun onStart() {
        super.onStart()

    }


    private fun clickVoteBtn() {
        val intent = Intent(context!!, FingerPrintActivity::class.java)
        startActivity(intent)
    }
}

