package org.app.siekraf.core.navigation.graph.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.app.siekraf.core.navigation.AUTH_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.utils.ekrafViewModelFactory
import org.app.siekraf.feature_login.ui.LoginScreen
import org.app.siekraf.feature_login.ui.LoginViewModel
import org.app.siekraf.feature_main.ui.MainScreen
import org.app.siekraf.feature_signup.ui.FirstSignupScreen
import org.app.siekraf.feature_signup.ui.SecondSignupScreen
import org.app.siekraf.feature_signup.ui.SignupViewModel

@Composable
fun AuthNavGraph(
    navController: NavHostController
) {
    val signupViewModel = viewModel<SignupViewModel>(factory = ekrafViewModelFactory {
        SignupViewModel()
    })
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.FirstSignUp.route) {
            FirstSignupScreen(navController = navController, viewModel = signupViewModel)
        }
        composable(route = Screen.SecondSignUp.route) {
            SecondSignupScreen(navController = navController, viewModel = signupViewModel)
        }
        composable(route = Screen.Main.route) {
            MainScreen()
        }
    }
}