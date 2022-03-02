package com.example.chat.views

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.chat.databinding.ActivitySignUpBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySignUpBinding

    private lateinit var auth: FirebaseAuth;
    private lateinit var db: FirebaseDatabase;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // don't show progressbar
        binding.loadingBar.isVisible = false;

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        getSupportActionBar()?.hide();

        binding.btnSignup.setOnClickListener{ signUp() };
    }

    fun signUp() {
        if (binding.inputUsername.text.isNotEmpty() && binding.inputEmail.text.isNotEmpty() && binding.inputPassword.text.isNotEmpty()) {
            // bring down keyboard: only runs if there is a view that is currently focused
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }

            // show progressbar while creating account
            binding.loadingBar.isVisible = true;

            auth.createUserWithEmailAndPassword(binding.inputEmail.text.toString(), binding.inputPassword.text.toString())
                .addOnCompleteListener { task -> signUpActionComplete(task) }

        } else {
            Toast.makeText(applicationContext, "Enter Credentials!", Toast.LENGTH_SHORT).show()
        }
    }

    fun signUpActionComplete(task: Task<AuthResult>) {
        binding.loadingBar.isVisible = false;

        if (task.isSuccessful) {
            Toast.makeText(applicationContext, "Sign Up Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}