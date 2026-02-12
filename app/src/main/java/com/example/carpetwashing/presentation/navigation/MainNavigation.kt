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

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Main : Screen("main")
}


@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val loginViewModel: LoginScreenViewModel = hiltViewModel()
    val isLoggedIn by loginViewModel.isLoggedInFlow.collectAsState(initial = null)

    if (isLoggedIn == null) {
        SplashScreen()
        return
    }

    val startDestination = if (isLoggedIn == true) {
        Screen.Main.route
    } else {
        Screen.Login.route
    }

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(Screen.Login.route) {
            LoginScreen(onNavigateTo = { navHostController.navigate(it) })
        }

        composable(Screen.Register.route) {
            RegisterScreen(onNavigateTo = { navHostController.navigate(it) })
        }

        composable(Screen.Main.route) {
            MainScreen(onNavigateTo = { navHostController.navigate(it) })
        }
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

