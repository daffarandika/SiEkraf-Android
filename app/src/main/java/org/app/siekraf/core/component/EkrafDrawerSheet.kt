package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp

@Composable
fun EkrafDrawerSheet(
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxWidth(0.6f)){
        Text("Drawer title", modifier = modifier.padding(16.dp), style = MaterialTheme.typography.headlineLarge)
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed neque enim, euismod a mattis id, commodo congue arcu. Etiam id luctus libero. Praesent vitae vulputate eros, vitae congue felis. Nam justo nunc, suscipit eget sapien nec, lobortis blandit orci. Sed tincidunt dolor vel pharetra condimentum.", modifier = modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
    }

}