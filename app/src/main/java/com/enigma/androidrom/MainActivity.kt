package com.enigma.androidrom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigma.androidrom.data.User
import com.enigma.androidrom.data.UserDatabase
import com.enigma.androidrom.data.UserRepository
import com.enigma.androidrom.data.UserViewModel

//Rom database mirip meyimpan data ke database
//databasenya namanya sql lite
class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        userViewModel.addUser(User(firstName = "nopal", lastName = "aqil", age = 20))
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this,
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    val userDao = UserDatabase.getDatabase(this@MainActivity).dao()
                    val userRepository = UserRepository(userDao)
                    return UserViewModel(userRepository) as T
                }
            }).get(UserViewModel::class.java)
    }
}