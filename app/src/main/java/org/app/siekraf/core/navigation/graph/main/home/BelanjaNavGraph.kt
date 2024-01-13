package org.app.siekraf.core.navigation.graph.main.home

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.BELANJA_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.feature_belanja.ui.BelanjaScreen
import org.app.siekraf.feature_product_detail.ui.ProductDetailScreen

fun NavGraphBuilder.belanjaNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Belanja.route,
        route = BELANJA_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Belanja.route) {
            BelanjaScreen(navController = navController)
        }
        composable(route = "${Screen.ProductDetail.route}/{product_id}",
            arguments = listOf(
                navArgument("product_id"){ type = NavType.StringType }
            )
        ) {
            ProductDetailScreen(id = it.arguments?.getString("product_id").toString(), navController = navController)
        }
    }
}