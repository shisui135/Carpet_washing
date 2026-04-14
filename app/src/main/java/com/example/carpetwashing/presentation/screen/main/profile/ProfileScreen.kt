package com.example.carpetwashing.presentation.screen.main.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.carpetwashing.presentation.navigation.Screen

@Composable
fun ProfileScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row{
            Text(
                modifier = Modifier.weight(1f)
                    .clickable {
                    onNavigateTo(Screen.Login)
                },
                text = "Выйти",
                maxLines = 1,
                softWrap = false,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onError
            )
        }
    }
}