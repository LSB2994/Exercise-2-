package com.example.roomcrud.states

import com.example.roomcrud.models.User

data class UserState(
    val listUsers: List<User> = emptyList(),
)
