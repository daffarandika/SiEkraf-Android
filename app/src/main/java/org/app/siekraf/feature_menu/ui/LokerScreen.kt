package org.app.siekraf.feature_menu.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.app.siekraf.core.component.EkrafButton

data class Loker(
    val judul: String = "Sentra Bulu Mata",
    val deskripsi: AnnotatedString,
)
@Composable
fun LokerScreen(loker: Loker, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(
            10.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text(text = loker.judul, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.size(24.dp))
            Text(text = loker.deskripsi, style = MaterialTheme.typography.bodyMedium)
            EkrafButton(onClick = { /*TODO*/ }, text = "Daftar", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun LSPrev() {
    val deskripsi = buildAnnotatedString  {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)) {
            append("Persyaratan: \n")
        }
        append("Pendidikan minimal SMP \n")
        append("Jujur, Ulet, Kuat, Disiplin, Sabar Siap bekerja tanpa jadwal tetap (Freelance)\n")
    }
    LokerScreen(loker = Loker(
        deskripsi = deskripsi
    )
    )
    
}