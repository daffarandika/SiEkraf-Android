package org.app.siekraf.core.navigation.graph.main

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.app.siekraf.core.navigation.MAIN_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.navigation.graph.main.home.homeNavGraph
import org.app.siekraf.core.navigation.graph.main.notification.notificationNavGraph
import org.app.siekraf.core.utils.ekrafViewModelFactory
import org.app.siekraf.feature_home.ui.HomeScreen
import org.app.siekraf.feature_home.ui.HomeViewModel
import org.app.siekraf.feature_notification.ui.NotificationScreen
import org.app.siekraf.feature_qr.ui.QrScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        route = MAIN_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Main.route) {
            HomeScreen(navController = navController, viewModel = viewModel(factory = ekrafViewModelFactory { HomeViewModel() }))
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen()
        }
        composable(route = Screen.QrCode.route) {
            QrScreen()
        }
        homeNavGraph(navController = navController)
        notificationNavGraph(navController = navController)
        qrCodeNavGraph(navController = navController)
    }
}