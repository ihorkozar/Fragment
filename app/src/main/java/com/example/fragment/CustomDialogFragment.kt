package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        val sendBtn = view.findViewById<Button>(R.id.send_btn)
        val cancelBtn = view.findViewById<Button>(R.id.cancel_btn)
        sendBtn.setOnClickListener{

        }
        cancelBtn.setOnClickListener {
            dismiss()
        }
        return view
    }
}