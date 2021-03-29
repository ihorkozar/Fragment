package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        view.findViewById<Button>(R.id.start_dialog).setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.isCancelable = false
            fragmentManager?.let { it1 -> dialog.show(it1, "CustomDialog") }
        }
        return view
    }
}