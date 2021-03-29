package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment3 : Fragment() {

    lateinit var listener: Fragment3Listener

    interface Fragment3Listener {
        fun sendText(text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment3Listener){
            listener = context
        } else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)
        val createBtn = view.findViewById<Button>(R.id.create_btn)
        val editText = view.findViewById<TextView>(R.id.text_view)
        if (editText.text.length > 3){
            createBtn.isClickable = true
            createBtn.setOnClickListener{
                //listener.sendText(editText.text.toString())
                var dialog = CustomDialogFragment()
                fragmentManager?.let { it -> dialog.show(it, "CustomDialog") }
            }
        }
        return view
    }
}