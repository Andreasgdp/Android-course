package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class activity_calender : AppCompatActivity() {

    private var name: String? = null
    private var address: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        name = intent.getStringExtra(Constants.NAME_KEY)
        address = intent.getStringExtra(Constants.ADDRESS_KEY)
        val btnBack: Button = findViewById(R.id.button_prev)
        btnBack.setOnClickListener { previous() }
    }

    /** Called when the user taps the Send button */
    fun next(view: View) {
        val dpDateOfBirth: CalendarView = findViewById(R.id.calendarView)
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formattedDate = sdf.format(dpDateOfBirth.date)
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(Constants.NAME_KEY, name)
            putExtra(Constants.ADDRESS_KEY, address)
            putExtra(Constants.DATE_OF_BIRTH_KEY, formattedDate)
        }
        startActivity(intent)
    }

    fun previous() {
        finish()
    }
}