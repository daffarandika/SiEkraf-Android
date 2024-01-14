package org.app.siekraf.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.theme.LightBlue

@Composable
fun EkrafSecondaryTopBar(
    modifier: Modifier = Modifier,
    items: List<BarNavigationItem>,
    navController: NavHostController,
    activeIndex: Int,
    onActiveIndexChanged: (Int) -> Unit = {},
) {
    LazyRow(
        modifier = modifier
            .background(Color.LightGray)
        ,
        content = {
            this.itemsIndexed(items = items) {index, item ->
                Row (
                    modifier = modifier
                        .clickable {
                            onActiveIndexChanged(index)
                        }
                        .let {
                            if (activeIndex == index)
                                return@let it.background(LightBlue)
                            else
                                it
                        }
                        .padding(horizontal = 15.dp, vertical = 7.dp)
                ) {
                    Text( text = item.text )
                    Divider(color = Black)
                }
            }
        }
    )
}
