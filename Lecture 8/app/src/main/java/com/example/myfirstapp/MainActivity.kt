package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import com.example.myfirstapp.database.User

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    private lateinit var etYourName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun next(view: View) {
        val editText = findViewById<EditText>(R.id.editTextPersonName)
        val message = editText.text.toString()

        if (!TextUtils.isEmpty(message)) {
            val intent = Intent(this, activity_address::class.java).apply {
                putExtra(Constants.NAME_KEY, message)
            }

            val updatedUser = User(
                uid = currentUser.uid,
                address = currentUser.address,
                dateOfBirth = currentUser.dateOfBirth,
                name = etYourName.text.toString()
            )
            UserDao.userDao().update(updatedUser)
        }

        startActivity(intent)
    }
}