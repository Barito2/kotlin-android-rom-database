package com.enigma.androidrom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mst_user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val age: Int
)