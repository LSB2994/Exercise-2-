package com.example.roomcrud.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcrud.models.User
import com.example.roomcrud.room.UserDao
import com.example.roomcrud.states.UserState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserViewModel(
    private val dao:UserDao
): ViewModel() {
    var state by mutableStateOf(UserState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllUser().collectLatest {
                state = state.copy(
                    listUsers = it
                )
            }
        }
    }

    fun insetUser(user: User) = viewModelScope.launch{
        dao.insertUser(user = user)
    }

    fun updateUser(user: User) = viewModelScope.launch{
        dao.updateUser(user = user)
    }

    fun deleteUser(user: User) = viewModelScope.launch{
        dao.deleteUser(user = user)
    }

    fun getUserById(id: Int) = viewModelScope.launch{
        dao.getUserById(id = id)
    }



}