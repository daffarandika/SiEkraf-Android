package org.app.siekraf.feature_main.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoveToInbox
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.app.siekraf.core.component.EkrafBottomBar
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.navigation.graph.main.MainNavGraph
import org.app.siekraf.core.theme.GoldYellow
import org.app.siekraf.feature_home.ui.HomeViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    var activeIndex by remember {
        mutableIntStateOf(0)
    }
    val navController: NavHostController = rememberNavController()

    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val density = LocalDensity.current

    val homeViewModel: HomeViewModel = hiltViewModel()

    showBottomBar = when(navBackStackEntry?.destination?.route) {
        Screen.Belanja.route -> false "${Screen.ProductDetail.route}/{product_id}" -> false
        else -> true
    }
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            AnimatedVisibility(
                visible = showBottomBar,
                enter = slideInVertically {
                    with(density) { 40.dp.roundToPx() }
                },
                exit = slideOutVertically {
                    with(density) { 100.dp.roundToPx() }
                }
            ) {
                val backrground = MaterialTheme.colorScheme.background
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.QrCode.route)
                    },
                    containerColor = GoldYellow,
                    shape = CircleShape,
                    modifier = modifier
                        .offset(y = 30.dp)
                        .drawBehind {
                            drawCircle(
                                color = backrground,
                                radius = 70f
                            )
                        }
                ) {
                    Icon(imageVector = Icons.Outlined.QrCodeScanner, null, tint = Black)
                }
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = showBottomBar,
                enter = slideInVertically {
                    with(density) { 40.dp.roundToPx() }
                },
                exit = slideOutVertically {
                    with(density) { 100.dp.roundToPx() }
                }
            ) {
                EkrafBottomBar(
                    items = listOf(
                        BarNavigationItem(text = "Home", screen = Screen.Home, icon = {Icon(imageVector = Icons.Outlined.Home, contentDescription = null)}),
                        BarNavigationItem(text = "Notifikasi", screen = Screen.Notification, icon = {Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)}),
                        BarNavigationItem(text = "Kotak Saran", screen = Screen.KotakSaran, icon = {Icon(imageVector = Icons.Outlined.MoveToInbox, contentDescription = null)}),
                        BarNavigationItem(text = "Profil", screen = Screen.Profile, icon = {Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null)})
                    ),
                    navController = navController,
                    activeIndex = activeIndex,
                    onActiveIndexChanged = {activeIndex = it}
                )
            }
        }
    ) {
        Box(modifier.padding(it)) {
            MainNavGraph(navController = navController)
        }
    }
}
