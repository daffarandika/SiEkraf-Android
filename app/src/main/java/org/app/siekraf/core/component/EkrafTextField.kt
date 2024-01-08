package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.app.siekraf.core.theme.LightGrey

@Composable
fun EkrafTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String,
    isError: Boolean= false,
    onValueChange: (String) -> Unit,
    showLabel: Boolean = false,
    hint: @Composable () -> Unit = {},
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (showLabel){
            Text(labelText, Modifier.align(Alignment.Start))
        }
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
                focusedBorderColor = LightGrey,
                unfocusedBorderColor = LightGrey,
                cursorColor = LightGrey,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
            ),
            isError = isError,
            trailingIcon = {
                if (isError) {
                    Icon(Icons.Filled.Error, "Error")
                }
            },
            placeholder = hint,
            singleLine = true,
        )
    }
}

@Preview
@Composable
fun EkrafTextFieldPreview() {
   EkrafTextField(value = "", onValueChange = {})
}