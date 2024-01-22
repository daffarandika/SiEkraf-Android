package org.app.siekraf.core.navigation.graph.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.app.siekraf.core.navigation.MAIN_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.navigation.graph.main.home.homeNavGraph
import org.app.siekraf.core.navigation.graph.main.menu.menuNavGraph
import org.app.siekraf.core.navigation.graph.main.notification.notificationNavGraph
import org.app.siekraf.feature_home.ui.HomeScreen
import org.app.siekraf.feature_home.ui.HomeViewModel
import org.app.siekraf.feature_kotak_saran.ui.KotakSaranScreen
import org.app.siekraf.feature_menu.ui.MenuScreen
import org.app.siekraf.feature_notification.ui.NotificationScreen
import org.app.siekraf.feature_profile.ui.ProfileScreen
import org.app.siekraf.feature_qr.ui.QrScreen

@Composable
fun MainNavGraph(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        route = MAIN_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Main.route) {
            HomeScreen(navController = navController, viewModel = homeViewModel)
        }
        composable(route = Screen.Notification.route) {
            NotificationScreen()
        }
        composable(route = Screen.QrCode.route) {
            QrScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Screen.KotakSaran.route) {
            KotakSaranScreen()
        }
        composable(route = Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
        menuNavGraph(navController = navController)
        homeNavGraph(navController = navController)
        notificationNavGraph(navController = navController)
        qrCodeNavGraph(navController = navController)
    }
}