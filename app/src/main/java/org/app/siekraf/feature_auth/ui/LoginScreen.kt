package org.app.siekraf.feature_auth.ui

import android.content.Context
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafPasswordTextField
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.model.Output
import org.app.siekraf.core.theme.SiEkrafTheme
import org.app.siekraf.feature_auth.data.model.LoginUiState

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    loginUiState: LoginUiState,
    context: Context = LocalContext.current,
    updateEmailInput: (String) -> Unit = {},
    updatePasswordInput: (String) -> Unit = {},
    updatePasswordVisibility: (Boolean) -> Unit = {},
    canLogin: Boolean = false,
    setError: () -> Unit = {},
    removeError: () -> Unit = {},
    doLoginRequest: () -> Unit = {},
    navigateToHome: () -> Unit = {},
    navigateToSignUp: () -> Unit = {}
) {

    LaunchedEffect(loginUiState.token) {
        when (loginUiState.token) {
            is Output.Error -> {
                Toast.makeText(context, "error ${(loginUiState.token as Output.Error).exception.message}", Toast.LENGTH_SHORT).show()
            }
            is Output.Success -> {
                delay(500)
                navigateToHome()
            }
            is Output.Loading -> {

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
            value = loginUiState.email,
            hint = {Text("Email")},
            onValueChange = {updateEmailInput(it)},
            modifier = Modifier.fillMaxWidth(),
            isError = loginUiState.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafPasswordTextField(
            value = loginUiState.password,
            isError = loginUiState.isPasswordError,
            showPassword = loginUiState.isPasswordVisible,
            modifier = Modifier.fillMaxWidth(),
            hint = {Text("Password")},
            onValueChange = { updatePasswordInput(it) },
            onShowPasswordChange = { updatePasswordVisibility(!loginUiState.isPasswordVisible) },
        )

        Spacer(Modifier.size(128.dp))

        TextButton(onClick = { navigateToSignUp() }) {
            Text("Belum Punya akun? Daftar Sekarang")
        }
        EkrafButton(
            onClick = {
                if (canLogin) {
                    removeError()
                    doLoginRequest()
                } else {
                    setError()
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
    SiEkrafTheme {
        LoginScreen(
            Modifier
                .width(375.dp)
                .height(812.dp),
            LoginUiState()
        )
    }
}
