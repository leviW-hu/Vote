package com.example.voteapp.dialogs

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import com.example.voteapp.FingerPrintActivity
import com.example.voteapp.R
import com.example.voteapp.ui.main.widgets.CountDownAnimation
import kotlinx.android.synthetic.main.fragment_vote_dialog.*


class VoteDialogFragment : DialogFragment() {

    companion object {

        const val TAG = "SimpleDialog"

        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String): VoteDialogFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = VoteDialogFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vote_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView(view: View) {
        rb_vote1.text = arguments!![KEY_TITLE].toString()
        rb_vote2.text = arguments!![KEY_SUBTITLE].toString()
    }

    private fun setupClickListeners(view: View) {
        val radioGroup = view.findViewById<RadioGroup>(R.id.rg_vote_dialog_group)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            btn_vote_ok.isEnabled = false
            tv_vote_dialog_description.text = getString(R.string.wait_5_sec)

            val countDownAnimation = CountDownAnimation(tv_animation_space, 5)
            countDownAnimation.start()
            countDownAnimation.setCountDownListener { btn_vote_ok.isEnabled = true }
        }

        val okBtn = view.findViewById<Button>(R.id.btn_vote_ok)
        okBtn.setOnClickListener{
            val intent = Intent(context!!, FingerPrintActivity::class.java)
            intent.putExtra("vote",view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text)
            startActivity(intent)
            dismiss()
        }

        btn_dialog_cancel.setOnClickListener{ dismiss() }

    }
}
