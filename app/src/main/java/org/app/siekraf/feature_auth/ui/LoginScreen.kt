package org.app.siekraf.feature_auth.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafPasswordTextField
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.model.Output
import org.app.siekraf.core.navigation.Screen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val uiState = loginViewModel.uiState.collectAsState()

    val loginState by remember { loginViewModel.loginState }.collectAsState()

    val ctx = LocalContext.current

    LaunchedEffect(loginState)
    {
        when (loginState) {
            is Output.Error -> {
                Toast.makeText(ctx, "error ${(loginState as Output.Error).exception.message}", Toast.LENGTH_SHORT).show()
            }
            is Output.Loading -> {
                Toast.makeText(ctx, "loading", Toast.LENGTH_SHORT).show()
            }
            is Output.Success -> {
                delay(500)
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                }
            }
        }
    }

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

        Text("Masuk", style = MaterialTheme.typography.headlineLarge)

        Spacer(Modifier.size(16.dp))

        EkrafTextField(
            value = uiState.value.email,
            hint = {Text("Email")},
            onValueChange = {loginViewModel.updateEmailInput(it)},
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.value.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafPasswordTextField(
            value = uiState.value.password,
            isError = uiState.value.isPasswordError,
            showPassword = uiState.value.isPasswordVisible,
            modifier = Modifier.fillMaxWidth(),
            hint = {Text("Password")},
            onValueChange = { loginViewModel.updatePasswordInput(it) },
            onShowPasswordChange = { loginViewModel.updatePasswordVisibility(!uiState.value.isPasswordVisible) },
        )

        Spacer(Modifier.size(128.dp))

        TextButton(onClick = { navController.navigate(Screen.FirstSignUp.route) }) {
            Text("Belum Punya akun? Daftar Sekarang")
        }
        EkrafButton(
            onClick = {
                    loginViewModel.login()
            },
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}




@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        Modifier
            .width(375.dp)
            .height(812.dp)
            ,
        navController = rememberNavController()
    )
}
