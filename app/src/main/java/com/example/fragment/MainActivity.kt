package com.example.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.util.*

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Listener {
    private val fragment1 = Fragment1()
    private val fragment2 = Fragment2()
    private val fragment3 = Fragment3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_1, fragment1)
            .add(R.id.container_2, fragment2)
            .add(R.id.container_3, fragment3)
            .commit()
    }

    override fun onInputSent() {
        fragment2.updateColor(randomColor())
        fragment3.updateColor(randomColor())
    }

    override fun changeFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_2, fragment3)
            .replace(R.id.container_3, fragment2)
            .commit()
    }

    private fun randomColor(): Int{
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

}