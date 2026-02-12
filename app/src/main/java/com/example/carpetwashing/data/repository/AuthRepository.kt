package com.example.carpetwashing.data.repository

import com.example.carpetwashing.data.datastore.DataStoreManager
import com.example.carpetwashing.domain.dao.UserDao
import com.example.carpetwashing.domain.entity.User
import com.example.carpetwashing.domain.util.Result
import java.util.UUID
import javax.inject.Inject


class AuthRepository @Inject constructor(
    private val userDao: UserDao,
    private val dataStoreManager: DataStoreManager
) {
    val isLoggedInFlow = dataStoreManager.isLoggedInFlow

    suspend fun login(email: String, password: String): Result<Unit> {
        val loginUser = userDao.login(email, password)
        return if (loginUser == null) Result.Failure("Login failed")
        else {
            dataStoreManager.setLoggedIn(true)
            Result.Success("Successfully logged in", Unit)
        }
    }

    suspend fun register(username: String, email: String, password: String): Result<Unit> {
        if (userDao.getUserByEmail(email) != null)
            return Result.Failure("Пользователь с такой почтой уже есть")
        val user = User(UUID.randomUUID().toString(), username, email, password)
        userDao.addUser(user)
        return Result.Success("Вы успешно зарегистрировались", Unit)
    }

    suspend fun setLoggedIn(value: Boolean) {
        dataStoreManager.setLoggedIn(value)
    }
}


