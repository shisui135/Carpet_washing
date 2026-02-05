package com.example.carpetwashing.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: String,

    @ColumnInfo("username")
    val username: String,

    @ColumnInfo("email")
    val email: String,

    @ColumnInfo("password")
    val password: String
)
