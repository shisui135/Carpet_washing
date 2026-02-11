package com.example.carpetwashing.domain.util

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.carpetwashing.presentation.screen.main.navigation.MainScreenNavigationRoute

data class BottomNavItem(
    val icon: ImageVector,
    val titleResId: Int,
    val route: MainScreenNavigationRoute
)
