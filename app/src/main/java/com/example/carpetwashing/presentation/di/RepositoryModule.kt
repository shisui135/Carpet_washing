package com.example.carpetwashing.presentation.di

import com.example.carpetwashing.data.repository.AuthRepository
import com.example.carpetwashing.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(userDao: UserDao): AuthRepository {
        return AuthRepository(userDao)
    }
}