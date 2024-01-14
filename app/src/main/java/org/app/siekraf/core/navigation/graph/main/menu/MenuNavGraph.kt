package org.app.siekraf.core.navigation.graph.main.menu

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.BELANJA_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.feature_belanja.ui.BelanjaScreen
import org.app.siekraf.feature_menu.ui.MenuScreen
import org.app.siekraf.feature_product_detail.ui.ProductDetailScreen

fun NavGraphBuilder.menuNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Menu.route,
        route = BELANJA_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Menu.route) {
            MenuScreen(navController = navController)
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