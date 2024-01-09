package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun EkrafRadioButton(
    modifier: Modifier = Modifier,
    label: String? = null,
    list: List<String>,
    selectedIndex: Int,
    onSelectedChanged: (Int) -> Unit,
) {
    Column (
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ){
        label?.let {
            Text(text = it, style = MaterialTheme.typography.bodyMedium)
        }
        Row(modifier = Modifier){
            list.forEachIndexed { index, item ->
                Row(verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = index == selectedIndex,
                        onClick = { onSelectedChanged(index) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor =  SkyBlue,
                        )
                    )
                    Text(text = item, fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview
@Composable
fun EkrafRadioButtonPreview() {
    EkrafRadioButton(label = "cw kh?", list = listOf("Male", "Female"), selectedIndex = 0, onSelectedChanged = {})
}