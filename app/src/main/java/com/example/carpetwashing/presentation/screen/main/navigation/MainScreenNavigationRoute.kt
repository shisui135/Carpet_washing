package com.example.carpetwashing.presentation.screen.main.navigation

import kotlinx.serialization.Serializable

sealed interface MainScreenNavigationRoute {
    @Serializable
    data object AboutUs: MainScreenNavigationRoute

    @Serializable
    data object Profile: MainScreenNavigationRoute

    @Serializable
    data object Order: MainScreenNavigationRoute
}