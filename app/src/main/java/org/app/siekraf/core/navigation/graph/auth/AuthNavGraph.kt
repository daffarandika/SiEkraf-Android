package org.app.siekraf.core.navigation.graph.auth

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.app.siekraf.core.navigation.AUTH_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.utils.ekrafViewModelFactory
import org.app.siekraf.feature_auth.data.model.SignupUiState
import org.app.siekraf.feature_auth.ui.LoginScreen
import org.app.siekraf.feature_main.ui.MainScreen
import org.app.siekraf.feature_auth.ui.FirstSignupScreen
import org.app.siekraf.feature_auth.ui.LoginViewModel
import org.app.siekraf.feature_auth.ui.SecondSignupScreen
import org.app.siekraf.feature_auth.ui.SignupViewModel

@Composable
fun AuthNavGraph(
    navController: NavHostController,
) {
    val signupViewModel: SignupViewModel = hiltViewModel()
    val loginViewModel: LoginViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.Login.route) {
            val loginUiState by loginViewModel.uiState.collectAsState()
            val context = LocalContext.current
            fun setError() {
                loginViewModel.updateEmailError(true)
                loginViewModel.updatePasswordError(true)
            }
            fun removeError()  {
                loginViewModel.updateEmailError(false)
                loginViewModel.updatePasswordError(false)
            }
            LoginScreen(
                loginUiState = loginUiState,
                context = context,
                updateEmailInput = { loginViewModel.updateEmailInput(it) },
                updatePasswordInput = { loginViewModel.updatePasswordInput(it) },
                updatePasswordVisibility = { loginViewModel.updatePasswordVisibility(it) },
                canLogin = loginViewModel.isReadyToLogin,
                doLoginRequest = {
                    if (loginViewModel.isReadyToLogin) {
                        removeError()
                        runBlocking {
                            loginViewModel.login()
                            delay(500)
                        }
                    } else {
                        setError()
                    }
                },
                navigateToHome = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Login.route)  {
                            inclusive = true
                        }
                    }
                },
                navigateToSignUp = { navController.navigate(Screen.FirstSignUp.route) }
            )
        }
        composable(route = Screen.FirstSignUp.route) {
            val signUpUiState by signupViewModel.uiState.collectAsState()
            FirstSignupScreen(
                signUpUiState = signUpUiState,
                updateNameInput = { signupViewModel.updateNameInput(it) },
                updateEmailInput = { signupViewModel.updateEmailInput(it) },
                updatePasswordInput = { signupViewModel.updatePasswordInput(it) },
                updatePasswordVisibility = { signupViewModel.updatePasswordVisibility(!signUpUiState.isPasswordVisible) },
                navigateToLogin = {
                    navController.popBackStack()
                },
                navigateToSecondSignUpScreen = {
                    navController.navigate(Screen.SecondSignUp.route)
                }
            )
        }
        composable(route = Screen.SecondSignUp.route) {
            SecondSignupScreen(navController = navController, viewModel = signupViewModel)
        }
        composable(route = Screen.Main.route) {
            MainScreen()
        }
    }
}