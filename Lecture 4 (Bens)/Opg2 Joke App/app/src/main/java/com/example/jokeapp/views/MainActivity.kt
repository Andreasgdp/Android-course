package com.example.jokeapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokeapp.R

import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.example.jokeapp.viewmodels.JokeViewModel

class MainActivity : AppCompatActivity() {

    // Create the view model which provides data for the view
    private val jokeViewModel: JokeViewModel by viewModels()
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            jokeViewModel.randomJoke()
        }

        // Observe the LiveData and update the view on change
        jokeViewModel.joke.observe(this) { joke ->
            textView.text = joke.text
        }
    }

}