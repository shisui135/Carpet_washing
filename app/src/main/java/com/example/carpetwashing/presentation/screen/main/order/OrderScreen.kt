package com.example.carpetwashing.presentation.screen.main.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carpetwashing.R
import com.example.carpetwashing.presentation.ui.component.ButtonStyle

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
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
                    .fillMaxWidth()
                    .border(
                        3.dp,
                        MaterialTheme.colorScheme.onTertiaryContainer,
                        RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.tertiaryContainer,


                ) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Нет заказов..",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }

            }

            Surface(
                modifier = modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .weight(1f)
                    .fillMaxWidth()
                    .border(
                        3.dp,
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = modifier.padding(top = 20.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Surface (
                            modifier = modifier
                                .padding(end = 5.dp, bottom = 5.dp)
                                .clip(RoundedCornerShape(15.dp)),
                            color = MaterialTheme.colorScheme.secondaryContainer
                        ) {
                            Text(
                                modifier = modifier.padding(start = 6.5.dp, end = 6.5.dp),
                                text = "+",
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.primaryContainer
                            )
                        }
                        Text(
                            text = "Оформить новый заказ",
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.secondary,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Box(
                        modifier = modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "нажмите заказать, чтобы узнать подробности",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                    ButtonStyle(
                        modifier = modifier
                            .padding(top = 25.dp, start = 80.dp, end = 80.dp),
                        onClick = {}
                    ) {
                        Text(
                            text = "Заказать",
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                    }
                }
            }

        }
    }
}