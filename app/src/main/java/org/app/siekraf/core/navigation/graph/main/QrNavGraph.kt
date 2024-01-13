package org.app.siekraf.core.navigation.graph.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.QR_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.feature_qr.ui.QrScreen

fun NavGraphBuilder.qrCodeNavGraph(navController: NavHostController) {
navigation(startDestination = Screen.QrCode.route, route = QR_GRAPH_ROUTE) {
        composable(Screen.QrCode.route) {
            QrScreen()
        }
    }
}
