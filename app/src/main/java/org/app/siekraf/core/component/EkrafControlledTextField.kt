package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import org.app.siekraf.core.theme.LightGrey
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun EkrafControlledTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String,
    isError: Boolean= false,
    onValueChange: (String) -> Unit,
    showLabel: Boolean = true,
    hint: @Composable () -> Unit = {},
    maxLines: Int = 1,
    numberKeyboard: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
        ,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        if (showLabel){
            Text(labelText, style = MaterialTheme.typography.titleLarge)
        }
        OutlinedTextField(
            maxLines = maxLines,
            singleLine = false,
            textStyle = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 2.5.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Top,
                        trim = LineHeightStyle.Trim.Both,
                    )
                )
            ),
            modifier = Modifier
                .fillMaxWidth().padding(0.dp)
            ,
            value = value,
            onValueChange = onValueChange,
            isError = isError,
            trailingIcon = {
                if (isError) {
                    Icon(Icons.Filled.Error, "Error")
                }
            },
            placeholder = hint,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = if (numberKeyboard) KeyboardType.Number else KeyboardType.Text),
        )
    }
}

@Preview
@Composable
fun EkrafContTextFieldPreview() {
    EkrafControlledTextField(labelText = "Nama",showLabel = true, value = "", onValueChange = {})
}
