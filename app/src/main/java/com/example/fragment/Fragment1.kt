package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    lateinit var listener: Fragment1Listener

    interface Fragment1Listener {
        fun changeColor()
        fun swapFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Fragment1Listener){
            listener = context
        } else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val changeColorBtn = view.findViewById<Button>(R.id.change_color_btn)
        changeColorBtn.setOnClickListener{
            listener.changeColor()
        }
        val changeFragmentBtn = view.findViewById<Button>(R.id.change_fragment_btn)
        changeFragmentBtn.setOnClickListener{
            listener.swapFragment()
        }
        return view
    }
}