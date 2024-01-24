package org.app.siekraf.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun EkrafBottomBar(
    modifier: Modifier = Modifier,
    items: List<BarNavigationItem>,
    navController: NavHostController,
    activeIndex: Int,
    onActiveIndexChanged: (Int) -> Unit = {},
) {
    Row(modifier
        .fillMaxWidth()
        .background(SkyBlue)) {
        items.forEachIndexed { index, item ->
            EkrafBottomTabIndicator(
                text = item.text,
                modifier = Modifier.fillMaxHeight(0.065f).weight((100/items.size).toFloat()),
                onClick = {
                    onActiveIndexChanged(index)
                    navController.navigate(item.screen.route){
                        popUpTo(route = navController.graph.route!!) {
                            inclusive = true
                        }
                    }
                },
                icon = item.icon,
                isActive = (index == activeIndex)
            )
        }
    }
}