package org.app.siekraf.core.navigation.graph.main.menu

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.app.siekraf.core.navigation.BELANJA_GRAPH_ROUTE
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.feature_menu.ui.Loker
import org.app.siekraf.feature_menu.ui.LokerScreen
import org.app.siekraf.feature_menu.ui.MenuScreen

fun NavGraphBuilder.menuNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Menu.route,
        route = BELANJA_GRAPH_ROUTE,
    ) {
        composable(route = Screen.Menu.route) {
            MenuScreen(navController = navController)
        }
        composable(route = Screen.Loker.route) {
            val deskripsi = buildAnnotatedString  {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
                    append("Persyaratan: \n")
                }
                append("Pendidikan minimal SMP \n")
                append("Jujur, Ulet, Kuat, Disiplin, Sabar Siap bekerja tanpa jadwal tetap (Freelance)\n")
            }
            LokerScreen(loker = Loker(
                deskripsi = deskripsi
            )
            )
        }
    }
}