package com.example.carpetwashing.presentation.screen.main.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carpetwashing.R
import com.example.carpetwashing.presentation.component.ButtonStyle
import com.example.carpetwashing.presentation.screen.login.LoginScreenEvent

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.fon_app),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.1f),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = modifier.weight(1.5f),
                painter = painterResource(id = R.drawable.logo_image),
                contentDescription = "CarpetWashing login image"
            )

            Text(
                modifier = modifier.weight(0.5f),
                text = "Добро пожаловать!",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            )

            Surface(
                modifier = modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Row() {
                    Column(
                    modifier = modifier
                        .weight(1f)
                        .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                        Text(
                            modifier = modifier.padding(top = 20.dp, start = 10.dp),
                            text = "Нет заказов",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onTertiary
                        )
                        ButtonStyle(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 50.dp, start = 10.dp)
                        ) {
                            Text(
                                text = "Подробее",
                                maxLines = 1,
                                softWrap = false,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.primaryContainer
                            )
                        }
                    }
                    Column(
                        modifier = modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Image(
                            modifier = modifier.padding(top = 20.dp)
                                .size(250.dp),
                            painter = painterResource(id = R.drawable.gazel_false),
                            contentDescription = "Gazel false"
                        )
                    }
                }


            }
            Surface(
                modifier = modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {

            }
        }
    }
}