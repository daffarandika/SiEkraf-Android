package org.app.siekraf.core.navigation.graph.main.notification

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.CART_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.feature_notification.ui.NotificationScreen


fun NavGraphBuilder.notificationNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Notification.route, route = CART_GRAPH_ROUTE) {
        composable(Screen.Notification.route) {
            NotificationScreen()
        }
    }
}