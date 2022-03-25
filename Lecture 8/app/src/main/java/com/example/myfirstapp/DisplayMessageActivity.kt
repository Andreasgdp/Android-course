package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    private var name: String? = null
    private var address: String? = null
    private var dateOfBirth: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        name = intent.getStringExtra(Constants.NAME_KEY)
        address = intent.getStringExtra(Constants.ADDRESS_KEY)
        dateOfBirth = intent.getStringExtra(Constants.DATE_OF_BIRTH_KEY)


        // Capture the layout's TextView and set the string as its text
        val nameView = findViewById<TextView>(R.id.nameView).apply {
            text = name
        }
        val addressView = findViewById<TextView>(R.id.addressView).apply {
            text = address
        }
        val dateOfBirthView = findViewById<TextView>(R.id.dateOfBirthView).apply {
            text = dateOfBirth
        }
    }
}
