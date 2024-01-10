package org.app.siekraf.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import org.app.siekraf.core.model.Aspirasi

@Composable
fun EkrafAspirasiChip (
    aspirasi: Aspirasi = Aspirasi(judul = "Judul", isi = "isi", poster = "Dapa", tanggal = "12 Desember 2023"),
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.padding(8.dp).width(130.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = rememberAsyncImagePainter(aspirasi.gambar),
            contentDescription = "Gambar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(16.dp)).size(128.dp)
        )
        Spacer(modifier.size(4.dp))
        Text(aspirasi.judul, overflow = TextOverflow.Ellipsis, maxLines = 2)
        Spacer(modifier.size(4.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            Icon(imageVector = Icons.Outlined.CalendarToday, contentDescription = null)
            Text(aspirasi.tanggal, fontSize = 10.sp)
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    EkrafAspirasiChip()
}