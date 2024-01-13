@file:OptIn(ExperimentalMaterial3Api::class)

package org.app.siekraf.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.siekraf.R


@Composable
fun EkrafTopBar(
    modifier: Modifier = Modifier,
    onLeadingIconClicked: () -> Unit = {},
    canNavigateBack: Boolean = false,
    title: String = "Si Ekraf",
    onTrailingIconClicked: () -> Unit = {},
) {
    if (canNavigateBack) {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(text = title, textAlign = TextAlign.Start)
                }
            },
            modifier = modifier,
            navigationIcon = {
                Row (verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = onLeadingIconClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_siekraf),
                        contentDescription = "Logo",
                        modifier = Modifier.size(48.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
            ),
            actions = {
                IconButton(onClick = onTrailingIconClicked) {
                    Icon(Icons.Outlined.ShoppingCart, contentDescription = null)
                }
            }
        )
    } else {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = title)
                }
            },
            modifier = modifier,
            navigationIcon = {
                Row (verticalAlignment = Alignment.CenterVertically){
                    IconButton(onClick = onLeadingIconClicked) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_siekraf),
                        contentDescription = "Logo",
                        modifier = Modifier.size(48.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
            ),
            actions = {
                IconButton(onClick = onTrailingIconClicked) {
                    Icon(Icons.Outlined.ShoppingCart, contentDescription = null)
                }
            }
        )
    }
}

@Preview
@Composable
fun EkrafTopBarBackPreview() {
    EkrafTopBar(canNavigateBack = true)
}

@Preview
@Composable
fun EkrafTopBarNoBackPreview() {
    EkrafTopBar(canNavigateBack = false)
}
