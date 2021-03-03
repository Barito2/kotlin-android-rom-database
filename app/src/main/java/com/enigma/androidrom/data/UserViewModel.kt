package com.enigma.androidrom.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository): ViewModel() {

    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addUser(user)
        }
    }
}