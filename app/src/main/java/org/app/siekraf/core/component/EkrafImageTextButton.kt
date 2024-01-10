package org.app.siekraf.core.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EkrafImageTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
) {
    Column(modifier = modifier
        .fillMaxHeight()
        .width(55.dp)
        .padding(5.dp)
        .clickable {
            onClick()
        },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        Spacer(modifier.size(2.dp))
        Text(text, fontSize = 12.sp, style = TextStyle(
            lineHeight = 11.sp, textAlign = TextAlign.Center
        ))
    }
}
