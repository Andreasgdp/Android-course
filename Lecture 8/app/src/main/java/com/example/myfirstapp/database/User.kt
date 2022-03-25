package com.example.myfirstapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class User {
    @PrimaryKey
    var uid = 0
    var name: String? = null
    var address: String? = null
    var dateOfBirth: Long = 0
}