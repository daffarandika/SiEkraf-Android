package org.app.siekraf.feature_login.ui

import android.util.Log.v
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafPasswordTextField
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.theme.SkyBlue
import org.app.siekraf.core.utils.ekrafViewModelFactory

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
//    viewModel: LoginViewModel = LoginViewModel()
) {

    val viewModel = viewModel<LoginViewModel>(
        factory = ekrafViewModelFactory { LoginViewModel() }
    )

    val uiState = viewModel.uiState.collectAsState()

    val loginState by remember { viewModel.loginState }.collectAsState()

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
            hint = {Text("Email", color = Color.LightGray)},
            onValueChange = {viewModel.updateEmailInput(it)},
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.value.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafPasswordTextField(
            value = uiState.value.password,
            isError = uiState.value.isPasswordError,
            showPassword = uiState.value.isPasswordVisible,
            modifier = Modifier.fillMaxWidth(),
            hint = {Text("Password", color = Color.LightGray)},
            onValueChange = { viewModel.updatePasswordInput(it) },
            onShowPasswordChange = { viewModel.updatePasswordVisibility(!uiState.value.isPasswordVisible) },
        )

        Spacer(Modifier.size(128.dp))

        TextButton(onClick = { /*TODO*/ }) {
            Text("Belum Punya akun? Daftar Sekarang", color = SkyBlue)
        }
        EkrafButton(
            onClick = {
                  navController.navigate(Screen.Main.route) {
                      popUpTo(route = Screen.Login.route) {
                          inclusive = true
                      }
                  }
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
            .background(color = Color(0xFFFFFFFF)),
        navController = rememberNavController()
    )
}
