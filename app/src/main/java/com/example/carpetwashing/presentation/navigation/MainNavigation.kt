package com.example.carpetwashing.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carpetwashing.R
import com.example.carpetwashing.presentation.screen.login.LoginScreen
import com.example.carpetwashing.presentation.screen.login.LoginScreenViewModel
import com.example.carpetwashing.presentation.screen.main.MainScreen
import com.example.carpetwashing.presentation.screen.register.RegisterScreen
import kotlinx.serialization.Serializable


@Serializable
sealed class Screen {
    @Serializable
    object Login : Screen()
    @Serializable
    object Register : Screen()
    @Serializable
    object Main : Screen()
}


@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navHostController,
        startDestination = if (isLoggedIn) Screen.Main else Screen.Login // Теперь передаем объекты
    ) {
        composable<Screen.Login> { // Тип указывается в угловых скобках
            LoginScreen(onNavigateTo = { navHostController.navigate(it) })
        }
        composable<Screen.Register> {
            RegisterScreen(onNavigateTo = { navHostController.navigate(it) })
        }
        composable<Screen.Main> {
            MainScreen(onNavigateTo = { navHostController.navigate(it) })
        }
    }



    @Composable
    fun SplashScreen() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_image),
                contentDescription = "CarpetWashing login image"
            )
            Text(
                text = "Загрузка...",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

