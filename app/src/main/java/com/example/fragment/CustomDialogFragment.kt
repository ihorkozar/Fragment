package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment() {

    lateinit var listener: DialogListener

    interface DialogListener {
        fun sendText(sendText: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DialogListener){
            listener = context
        } else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        val sendBtn = view.findViewById<Button>(R.id.send_btn)
        val cancelBtn = view.findViewById<Button>(R.id.cancel_btn)
        val editText = view.findViewById<TextView>(R.id.text_view)
        sendBtn.setOnClickListener{
            if (editText.text.length > 3){
                listener.sendText(editText.text.toString())
                dismiss()
            }
        }

        cancelBtn.setOnClickListener {
            dismiss()
        }
        return view
    }
}