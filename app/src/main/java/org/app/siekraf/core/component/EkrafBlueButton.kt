package org.app.siekraf.core.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EkrafButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String = "Button"
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
//            containerColor = SkyBlue
        ),
    ) {
        Text(
            modifier = modifier.padding(vertical =  10.dp),
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun EkrafButtonPreview() {
    EkrafButton(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp))
}