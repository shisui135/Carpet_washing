package com.example.carpetwashing.presentation.screen.register


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carpetwashing.R
import com.example.carpetwashing.presentation.navigation.Screen

import com.example.carpetwashing.presentation.component.ButtonStyle
import com.example.carpetwashing.presentation.screen.register.RegisterScreenViewModel
import com.example.carpetwashing.domain.util.Result

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit = {}
) {
    val viewModel = hiltViewModel<RegisterScreenViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val context = LocalContext.current
    LaunchedEffect(state.registerResult) {
        state.registerResult?.let { registerResult ->
            when (registerResult) {
                is Result.Success<*> -> {
                    onNavigateTo(Screen.Main)
                }

                is Result.Failure<*> -> {
                    Toast.makeText(
                        context, registerResult.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    RegisterView(
        state = state,
        onEvent = viewModel::onEvent,
        onNavigateTo = onNavigateTo
    )
}

@Composable
fun RegisterView(
    modifier: Modifier = Modifier,
    onNavigateTo: (Screen) -> Unit = {},
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {}
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
                painter = painterResource(id = R.drawable.logo_image),
                contentDescription = "CarpetWashing register image"
            )

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Регистрация аккаунта",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    modifier = Modifier.padding(top = 60.dp),
                    text = "Создайте аккаунт для заказа стирки ковров",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
            Surface(
                modifier = modifier
                    .size(340.dp, 320.dp),
                shape = RoundedCornerShape(24.dp),
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    OutlinedTextField(
                        value = state.username,
                        onValueChange = {
                            onEvent(RegisterScreenEvent.UsernameUpdated(it))
                        },
                        placeholder = {
                            Text("Введите имя", fontSize = 12.sp)
                        },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .height(56.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = "Name",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )

                    OutlinedTextField(
                        value = state.email,
                        onValueChange = {
                            onEvent(RegisterScreenEvent.EmailUpdated(it))
                        },
                        placeholder = {
                            Text("Введите почту", fontSize = 12.sp)
                        },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .height(56.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = "Email",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )

                    OutlinedTextField(
                        value = state.password,
                        onValueChange = {
                            onEvent(RegisterScreenEvent.PasswordUpdated(it))
                        },
                        placeholder = {
                            Text("Введите пароль", fontSize = 12.sp)
                        },
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = "Password",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    )
                    ButtonStyle(
                        onClick = { onEvent(RegisterScreenEvent.RegisterBtnClicked) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                    ) {
                        Text(
                            text = "Зарегистрироваться",
                            maxLines = 1,
                            softWrap = false,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                    }


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "уже есть аккаунт? - ",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .padding(top = 7.dp)
                        )
                        Text(
                            text = "Войти",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(top = 7.dp)
                                .clickable {
                                    onNavigateTo(Screen.Login)
                                }
                        )
                    }
                }

            }


            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(start = 30.dp, top = 100.dp),
                    text = "©2021 Стирка ковров",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    modifier = Modifier.padding(start = 90.dp, top = 100.dp),
                    text = "Поддержка / ",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    modifier = Modifier.padding(top = 100.dp),
                    text = "О нас",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}