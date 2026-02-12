package com.example.carpetwashing.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carpetwashing.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.carpetwashing.domain.util.Result


@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel(){

    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    val isLoggedInFlow = authRepository.isLoggedInFlow

    fun onLoginSuccess() {
        viewModelScope.launch {
            authRepository.setLoggedIn(true)
        }
    }

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailUpdated -> onEmailUpdated(event.newEmail)
            is LoginScreenEvent.PasswordUpdated -> onPasswordUpdated(event.newPassword)
            LoginScreenEvent.LoginBtnClicked -> login()
        }
    }

    private fun onEmailUpdated(newEmail: String) {
        _state.update { it.copy(email = newEmail) }
    }
    private fun onPasswordUpdated(newPassword: String) {
        _state.update { it.copy(password = newPassword) }
    }
    private fun login() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val email = state.value.email
            val password = state.value.password

            if (email.isEmpty() || password.isEmpty()) {
                _state.update { it.copy(isLoading = false) }
                return@launch
            }

            val result = withContext(Dispatchers.IO) { authRepository.login(email, password) }

            _state.update { it.copy(loginResult = result, isLoading = false) }

            if (result is Result.Success) {
                authRepository.setLoggedIn(true)
            }
        }
    }

}