package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EkrafPasswordTextField(
    modifier: Modifier = Modifier,
    labelText: String = "Label",
    showPassword: Boolean = false,
    onShowPasswordChange: () -> Unit,
    value: String,
    isError: Boolean = false,
    onValueChange: (String) -> Unit,
    showLabel: Boolean = false,
    hint: @Composable () -> Unit = {}
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {

        if (showLabel){
            Text(labelText, Modifier.align(Alignment.Start))
        }
        OutlinedTextField(
            shape = RoundedCornerShape(12.dp),
            value = value,
            textStyle = MaterialTheme.typography.bodyMedium,
            placeholder = hint,
            onValueChange = onValueChange,
            modifier = modifier,
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = isError,
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = onShowPasswordChange) {
                        Icon(Icons.Default.VisibilityOff, contentDescription = "Show")
                    }
                } else {
                    IconButton(onClick = onShowPasswordChange) {
                        Icon(Icons.Default.Visibility, contentDescription = "Hide")
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun EkrafPasswordTextFieldPreview() {
    EkrafPasswordTextField(onShowPasswordChange = { /*TODO*/ }, value = "", onValueChange = {})
}