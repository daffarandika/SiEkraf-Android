package org.app.siekraf.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.app.siekraf.core.theme.GoldYellow
import org.app.siekraf.core.theme.LightBlue
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun EkrafBottomTabIndicator(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    isActive: Boolean,
) {
    Column(modifier = modifier
        .background(color = if (isActive) LightBlue else SkyBlue)
        .clickable {
            onClick()
        }
        .let {
            if (isActive) {
                return@let it
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 8.dp)
            }
            it.padding(8.dp)
        }
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isActive) {
            Divider(
                color = GoldYellow,
                modifier = Modifier.height(6.dp).fillMaxWidth(0.8f).align(Alignment.CenterHorizontally).clip(
                    RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
            )
        }
        icon()
        Text(text, fontSize = 10.sp)
    }
}