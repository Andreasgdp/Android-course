package com.example.chat.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class UserService {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance();
    private var db: FirebaseDatabase = FirebaseDatabase.getInstance();


    fun createUser(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password);
    }
}