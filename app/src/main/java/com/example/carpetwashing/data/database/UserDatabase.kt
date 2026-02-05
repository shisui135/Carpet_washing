package com.example.carpetwashing.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carpetwashing.domain.dao.UserDao
import com.example.carpetwashing.domain.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}