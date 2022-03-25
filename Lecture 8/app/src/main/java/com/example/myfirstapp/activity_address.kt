package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class activity_address : AppCompatActivity() {

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        name = intent.getStringExtra(Constants.NAME_KEY)
        val btnBack: Button = findViewById(R.id.button_prev)
        btnBack.setOnClickListener { previous() }
    }

    /** Called when the user taps the Send button */
    fun next(view: View) {
        val editText = findViewById<EditText>(R.id.edittextaddress)
        val message = editText.text.toString()
        val intent = Intent(this, activity_calender::class.java).apply {
            putExtra(Constants.NAME_KEY, name)
            putExtra(Constants.ADDRESS_KEY, message)
        }
        startActivity(intent)
    }

    fun previous() {
        finish()
    }
}
