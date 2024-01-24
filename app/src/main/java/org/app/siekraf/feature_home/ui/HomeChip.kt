package org.app.siekraf.feature_home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.app.siekraf.core.theme.CreamYellow
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun HomeChip(
    icon: ImageVector,
    text: String = "",
    modifier: Modifier = Modifier,
    showBackground: Boolean = true,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .size(width = 60.dp, height = 70.dp)
            .clip(RoundedCornerShape(8.dp))
            .let {
                if (showBackground) {
                    return@let it.background(CreamYellow)
                } else {
                    return@let it
                }
            }
            .clickable { onClick() }
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            icon,
            null,
            modifier = Modifier.drawBehind {
                drawCircle(
                    color = SkyBlue,
                    radius = this.size.maxDimension / 1.5f
                )
            },
            tint = Color.White
        )
        Text(text, fontSize = 12.sp, style = TextStyle(
            lineHeight = 9.sp, textAlign = TextAlign.Center,
            color = Color.Black
        ))
    }
}

@Preview
@Composable
fun Prevv() {
    HomeChip(icon = Icons.Outlined.MenuBook, "buku keuangan")
}