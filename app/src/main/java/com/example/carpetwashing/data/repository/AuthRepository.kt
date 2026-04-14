package com.example.carpetwashing.data.repository

import com.example.carpetwashing.domain.dao.UserDao
import com.example.carpetwashing.domain.entity.User
import com.example.carpetwashing.domain.util.Result
import java.util.UUID
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val userDao: UserDao,
    private val localAuthManager: LocalAuthManager
) {

    suspend fun login(email: String, password: String): Result<Unit> {
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure<Unit>("Login failed")
        else {
            localAuthManager.rememberAuth(loginUser.id)
            Result.Success<Unit>("Successfully logged in")
        }

        localAuthManager

        return result
    }

    suspend fun register(username: String, email: String, password: String): Result<Unit> {
        if (userDao.getUserByEmail(email) != null)
            return Result.Failure("Пользователь с такой почтой уже есть")
        val user = User(id = UUID.randomUUID().toString(), username = username, email = email, password = password)
        userDao.addUser(user)

        localAuthManager.rememberAuth(user.id)

        return Result.Success("Вы успешно зарегистрировались", Unit)
    }
}


