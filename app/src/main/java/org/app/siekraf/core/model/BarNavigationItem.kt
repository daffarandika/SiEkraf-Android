package org.app.siekraf.core.model

import androidx.compose.runtime.Composable
import org.app.siekraf.core.navigation.Screen

data class BarNavigationItem(
    val text: String,
    val screen: Screen,
    val icon: @Composable () -> Unit,
)
