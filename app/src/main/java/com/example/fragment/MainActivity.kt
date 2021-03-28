package com.example.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), Fragment1.Fragment1Listener, Fragment3.Fragment3Listener {

    var colorFragment2: Int = 100
    var colorFragment3: Int = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = Fragment1()
        val fragment2 = Fragment2()
        val fragment3 = Fragment3()

        supportFragmentManager.beginTransaction()
            .add(R.id.container_1, fragment1, "F1")
            .add(R.id.container_2, fragment2, "F2")
            .add(R.id.container_3, fragment3, "F3")
            .commit()
    }

    override fun changeColor() {
        colorFragment2 = randomColor()
        colorFragment3 = randomColor()
        supportFragmentManager.findFragmentById(R.id.container_2)
            ?.view?.setBackgroundColor(colorFragment2)
        supportFragmentManager.findFragmentById(R.id.container_3)
            ?.view?.setBackgroundColor(colorFragment3)
    }

    override fun swapFragment() {
        changeFragment()
        changeColor()
    }

    private fun changeFragment(){
        val fragmentInContainer2 = supportFragmentManager.findFragmentById(R.id.container_2)
        if (fragmentInContainer2?.tag.equals("F2")) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_2, Fragment3(), "F3")
                .replace(R.id.container_3, Fragment2(), "F2")
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_2, Fragment2(), "F2")
                .replace(R.id.container_3, Fragment3(), "F3")
                .commit()
        }
    }

    private fun randomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }

    override fun sendText(text: String) {
        Fragment2().text.text = text
    }
}