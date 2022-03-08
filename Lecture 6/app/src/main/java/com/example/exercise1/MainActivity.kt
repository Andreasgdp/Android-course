package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.exercise1.ui.main.GreenFragment
import com.example.exercise1.ui.main.RedFragment
import com.example.exercise1.ui.main.WhiteFragment
import com.example.exercise1.ui.main.YellowFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_fragment, WhiteFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        val btnWhite = findViewById<Button>(R.id.button_white)
        btnWhite.setOnClickListener { updateFragment(WhiteFragment()) }
        val btnGreen = findViewById<Button>(R.id.button_green)
        btnGreen.setOnClickListener { updateFragment(GreenFragment()) }
        val btnYellow = findViewById<Button>(R.id.button_yellow)
        btnYellow.setOnClickListener { updateFragment(YellowFragment()) }
        val btnRed = findViewById<Button>(R.id.button_red)
        btnRed.setOnClickListener { updateFragment(RedFragment()) }
        //btnGreen.setOnClickListener { updateFragment(GreenFragment()) }
    }

    private fun updateFragment(currentFragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fragment, currentFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}
