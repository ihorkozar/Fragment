package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {
    //lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        //textView = view.findViewById(R.id.text_view)
        return view
    }

    /*override fun sendText(sendText: String) {
        textView.text = sendText
    }*/
}