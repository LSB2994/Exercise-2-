package com.example.roomcrud.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomcrud.models.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {
    abstract fun UserDao():UserDao
}