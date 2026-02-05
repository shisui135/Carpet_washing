package com.example.carpetwashing.data.repository

import com.example.carpetwashing.domain.dao.UserDao
import com.example.carpetwashing.domain.entity.User
import com.example.carpetwashing.domain.Result
import java.util.UUID
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val userDao: UserDao
){
    suspend fun login(email: String, password: String): Result {
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure<Unit>(msg = "Login failed")
        else Result.Success<Unit>("Successfully logged in")
        return result
    }

    suspend fun register(username: String, email: String, password: String): Result {
    if (userDao.getUserByEmail(email) != null) return Result.Failure<Unit>("Пользователь с такой почтой уже есть")

        val user = User(
            id = UUID.randomUUID().toString(),
            username = username,
            email = email,
            password = password
        )
        userDao.addUser(user)
        return Result.Success<Unit>("Вы успешно зарегистрировались")
    }
}