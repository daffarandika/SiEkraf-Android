package org.app.siekraf.feature_main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoveToInbox
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material.icons.outlined.QrCodeScanner
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafAppBar
import org.app.siekraf.core.component.EkrafBottomBar
import org.app.siekraf.core.model.BottomNavigationItem
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.navigation.graph.main.MainNavGraph
import org.app.siekraf.core.theme.GoldYellow

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    var activeIndex by remember {
        mutableIntStateOf(0)
    }
    val navController: NavHostController = rememberNavController()
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
                               FloatingActionButton(
                                   onClick = { /*TODO*/ },
                                   containerColor = GoldYellow,
                                   shape = CircleShape,
                                   modifier = modifier.offset(y = 30.dp).drawBehind {
                                       drawCircle(
                                           color = White,
                                           radius = 100f
                                       )
                                   }
                               ) {
                                   Icon(imageVector = Icons.Outlined.QrCodeScanner, null, )
                               }
        },
        bottomBar = {
            EkrafBottomBar(
                items = listOf(
                    BottomNavigationItem(text = "Home", screen = Screen.Home, icon = {Icon(imageVector = Icons.Outlined.Home, contentDescription = null)}),
                    BottomNavigationItem(text = "Notifikasi", screen = Screen.Notification, icon = {Icon(imageVector = Icons.Outlined.Notifications, contentDescription = null)}),
                    BottomNavigationItem(text = "Kotak Saran", screen = Screen.KotakSaran, icon = {Icon(imageVector = Icons.Outlined.MoveToInbox, contentDescription = null)}),
                    BottomNavigationItem(text = "Profil", screen = Screen.Profile, icon = {Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null)})
                ),
                navController = navController,
                activeIndex = activeIndex,
                onActiveIndexChanged = {activeIndex = it}
            )
        },
    ) {
        Box(modifier.padding(it)) {
            MainNavGraph(navController = navController)
        }
    }
}
