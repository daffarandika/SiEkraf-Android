package org.app.siekraf.core.navigation.graph.main.home

import androidx.compose.material3.DrawerState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.HOME_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.utils.ekrafViewModelFactory
import org.app.siekraf.feature_home.ui.HomeScreen
import org.app.siekraf.feature_home.ui.HomeViewModel

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    navigation(
        startDestination =  Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, viewModel = viewModel(factory = ekrafViewModelFactory { HomeViewModel() }))
        }
        belanjaNavGraph(navController = navController)
    }
}