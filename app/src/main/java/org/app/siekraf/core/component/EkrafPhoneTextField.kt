package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.siekraf.core.theme.LightGrey

@Composable
fun EkrafPhoneTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String,
    isError: Boolean= false,
    onValueChange: (String) -> Unit,
    showLabel: Boolean = false,
    trailingIcon: @Composable () -> Unit = {},
    hint: @Composable () -> Unit = {},
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (showLabel){
            Text(labelText, Modifier.align(Alignment.Start))
        }
        OutlinedTextField(
            shape = RoundedCornerShape(12.dp),
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightGray,
                unfocusedBorderColor = LightGray,
                cursorColor = LightGrey,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
            ),
            isError = isError,
            leadingIcon = {
                Row (modifier = Modifier.padding(start = 8.dp)){
                    Text("+62", color = Black)
                    Spacer(Modifier.size(10.dp))
                }
            },
            trailingIcon = {
                if (isError) {
                    Icon(Icons.Filled.Error, "Error")
                } else {
                    trailingIcon()
                }
            },
            placeholder = hint,
            singleLine = true,
        )
    }
}

@Preview
@Composable
fun EkrafPhoneTextFieldPreview() {
    EkrafPhoneTextField(value = "", onValueChange = {})
}
