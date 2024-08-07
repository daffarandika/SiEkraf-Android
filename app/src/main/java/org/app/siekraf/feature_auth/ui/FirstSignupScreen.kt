package org.app.siekraf.feature_auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafPasswordTextField
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.theme.SkyBlue
import org.app.siekraf.feature_auth.data.model.SignupUiState

@Composable
fun FirstSignupScreen(
    modifier: Modifier = Modifier,
    signUpUiState: SignupUiState = SignupUiState(),
    updateEmailInput: (String) -> Unit = {},
    updateNameInput: (String) -> Unit = {},
    updatePasswordInput: (String) -> Unit = {},
    updatePasswordVisibility: (Boolean) -> Unit = {},
    navigateToLogin: () -> Unit = {},
    navigateToSecondSignUpScreen: () -> Unit = {},
) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_siekraf),
            contentDescription = "Logo",
            modifier = Modifier.size(98.dp)
        )

        Spacer(Modifier.size(16.dp))

        Text("Daftar", style = MaterialTheme.typography.headlineLarge)

        Spacer(Modifier.size(16.dp))

        EkrafTextField(
            value = signUpUiState.name,
            hint = {Text("Nama", color = Color.LightGray)},
            onValueChange = { updateNameInput(it) },
            modifier = Modifier.fillMaxWidth(),
            isError = signUpUiState.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafTextField(
            value = signUpUiState.email,
            hint = {Text("Email", color = Color.LightGray)},
            onValueChange = {updateEmailInput(it)},
            modifier = Modifier.fillMaxWidth(),
            isError = signUpUiState.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafPasswordTextField(
            value = signUpUiState.password,
            isError = signUpUiState.isPasswordError,
            showPassword = signUpUiState.isPasswordVisible,
            modifier = Modifier.fillMaxWidth(),
            hint = {Text("Password", color = Color.LightGray)},
            onValueChange = { updatePasswordInput(it) },
            onShowPasswordChange = { updatePasswordVisibility(!signUpUiState.isPasswordVisible) },
        )

        Spacer(Modifier.size(128.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(0.46f))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(SkyBlue)
                    .size(16.dp),
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .size(16.dp),
            )
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(0.6f))
            IconButton(onClick = {
                navigateToSecondSignUpScreen()
            }) {
                Icon(
                    Icons.Filled.ArrowRightAlt,
                    contentDescription = "Next",
                    modifier = Modifier
                        .size(100.dp)
                )
            }

        }

        Spacer(Modifier.size(16.dp))

        TextButton(onClick = {
            navigateToLogin()
        }) {
            Text("Sudah Punya Akun? Masuk sekarang", color = SkyBlue)
        }
    }
}

@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun FirstSignupScreenPreview() {
    FirstSignupScreen(
        Modifier
            .width(375.dp)
            .height(812.dp)
            .background(color = Color(0xFFFFFFFF)),
    )
}
