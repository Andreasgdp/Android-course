package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_fragment, Article1Fragment())
                .addToBackStack(null)
                .commit()
        }
        val btnArticle1 = findViewById<Button>(R.id.button_article_1)
        btnArticle1.setOnClickListener { updateFragment(Article1Fragment()) }
        val btnArticle2 = findViewById<Button>(R.id.button_article_2)
        btnArticle2.setOnClickListener { updateFragment(Article2Fragment()) }
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
