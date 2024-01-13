package org.app.siekraf.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EkrafDrawerSheet(
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxWidth(0.9f)){
        Text("Profil Mitra", modifier = modifier.padding(16.dp), style = MaterialTheme.typography.headlineLarge)
        Text("BUMDes Kaliputih bernama BUMDes DADI MAKMUR, didirikan sekitar tahun 2022 di Desa Kaliputih, Kecamatan Purwojati, Kabupaten Banyumas atas inisiasi dari Pemerintah Desa Kaliputih (Darmono, selaku Kepala Desa). DADI MAKMUR, memiliki makna tersendiri yaitu “MENJADI SEJAHTERA” sesuai dengan keinginan dan cita-cita yang menginginkan terbentuknya sebuah badan yang dapat mengurusi perekonomian di Desa Kaliputih agar dapat maju dan berkembang dengan mengangkat kearifan lokal yang ada, serta mampu mencetak lapangan pekerjaan baru guna memperoleh pendapatan.",
            modifier = modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium.merge(
                TextStyle(
                    lineHeight = 20.sp
                )
            )
        )
    }
}