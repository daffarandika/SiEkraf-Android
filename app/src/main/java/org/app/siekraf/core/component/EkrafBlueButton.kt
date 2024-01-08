package org.app.siekraf.core.component

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun EkrafButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "Button"
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = SkyBlue
        ),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun EkrafButtonPreview() {
    EkrafButton(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp))
}