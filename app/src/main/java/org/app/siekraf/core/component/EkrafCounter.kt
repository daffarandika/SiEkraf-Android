package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.unit.dp

@Composable
fun EkrafCounter(
    number: Int = 0,
    onIncrement: (Int) -> Unit = {},
    onDecrement: (Int) -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 5.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { onIncrement(number) }) {
            Icon(Icons.Filled.ArrowDropUp, "Tambah")
        }
        Text(number.toString())
        IconButton(onClick = { onDecrement(number) }) {
            Icon(Icons.Filled.ArrowDropDown, "Kurangi")
        }

    }
}