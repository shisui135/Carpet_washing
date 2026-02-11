package com.example.carpetwashing.presentation.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carpetwashing.presentation.navigation.Screen
import com.example.carpetwashing.presentation.screen.main.aboutUs.AboutUsScreen
import com.example.carpetwashing.presentation.screen.main.navigation.BottomNavigationBar
import com.example.carpetwashing.presentation.screen.main.navigation.MainScreenNavigationRoute
import com.example.carpetwashing.presentation.screen.main.order.OrderScreen
import com.example.carpetwashing.presentation.screen.main.profile.ProfileScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onNavigateTo: (Screen) -> Unit

) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = MainScreenNavigationRoute.Order
        ) {
            composable<MainScreenNavigationRoute.Order> {
                OrderScreen()
            }
            composable<MainScreenNavigationRoute.AboutUs> {
                AboutUsScreen()
            }
            composable<MainScreenNavigationRoute.Profile> {
                ProfileScreen()
            }
        }
    }
}