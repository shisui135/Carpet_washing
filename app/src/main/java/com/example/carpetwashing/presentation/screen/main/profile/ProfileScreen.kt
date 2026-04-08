package com.example.carpetwashing.presentation.screen.main.profile

import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carpetwashing.presentation.component.ButtonStyle
import com.example.carpetwashing.presentation.navigation.Screen
import com.example.carpetwashing.presentation.screen.login.LoginScreenEvent

@Composable
fun ProfileScreen(
    onNavigateTo: (String) -> Unit = {}
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
                    onNavigateTo(Screen.Login.route)
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