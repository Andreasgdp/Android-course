package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class activity_address : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
    }

    /** Called when the user taps the Send button */
    fun next(view: View) {
        val editText = findViewById<EditText>(R.id.edittextaddress)
        val message = editText.text.toString()
        val intent = Intent(this, activity_calender::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}