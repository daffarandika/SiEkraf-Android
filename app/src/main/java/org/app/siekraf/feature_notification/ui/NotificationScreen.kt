package org.app.siekraf.feature_notification.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.component.EkrafDrawerSheet

@Composable
fun NotificationScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                EkrafDrawerSheet()
            }
        },
    ){
        Scaffold(
            topBar = {
                Surface(shadowElevation = 3.dp) {
                    EkrafTopBar(title = "", canNavigateBack = false, onLeadingIconClicked = {
                        scope.launch{
                            drawerState.apply {
                                if (isOpen) close() else open()
                            }
                        }
                    })
                }
            },
        ) {
            Column(
                modifier = Modifier.padding(it).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.size(64.dp))
                Text(
                    text = "Belum Ada Notifikasi",
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(Modifier.size(24.dp))
                Image(
                    painter = painterResource(id = R.drawable.bell_zero),
                    contentDescription = "belum ada notifikasi",
                    modifier = Modifier
                        .size(200.dp)
                )
            }
        }
    }
}