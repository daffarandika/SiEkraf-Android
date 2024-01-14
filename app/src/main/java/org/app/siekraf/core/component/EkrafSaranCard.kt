package org.app.siekraf.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.app.siekraf.core.model.Saran

@Composable
fun EkrafSaranCard(
    modifier: Modifier = Modifier,
    saran: Saran = Saran(),
    onClick: (String) -> Unit = {}
) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(
            10.dp
        ),
        modifier = modifier
            .clickable {
                onClick(saran.id)
            }
            .fillMaxWidth()
            .padding(10.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ){
            Row (
                modifier = modifier
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = saran.judul, style = MaterialTheme.typography.bodyLarge)
                Text(text = saran.tanggal, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = modifier.size(18.dp))
            Row {
                Text(text = saran.deskripsi, style = MaterialTheme.typography.bodyMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}