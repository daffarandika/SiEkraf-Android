package org.app.siekraf.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.app.siekraf.core.model.Menu
import org.app.siekraf.core.model.Produk

@Composable
fun EkrafProdukCard(
    modifier: Modifier = Modifier,
    produk: Produk,
    onClick: (String) -> Unit = {}
) {
    Card (
        elevation = CardDefaults.elevatedCardElevation(
            10.dp
        ),
        modifier = modifier
            .clickable {
                onClick(produk.id.toString())
            }
            .width(120.dp)
            .padding(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ){
            Image(
                painter = rememberAsyncImagePainter(produk.gambar),
                contentDescription = "Gambar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(128.dp)
            )
            Spacer(modifier.size(4.dp))
            Text(produk.hargaJual.toString())
            Spacer(modifier.size(4.dp))
            Text(text = produk.nama, style = MaterialTheme.typography.titleSmall)
        }
    }
}
@Composable
fun EkrafMenuCard(
    modifier: Modifier = Modifier,
    menu: Menu,
    onClick: (String) -> Unit = {}
) {
    Card (
        elevation = CardDefaults.elevatedCardElevation(
            10.dp
        ),
        modifier = modifier
            .clickable {
                onClick(menu.id.toString())
            }
            .width(120.dp)
            .padding(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxWidth()
        ){
            Image(
                painter = rememberAsyncImagePainter(menu.gambar),
                contentDescription = "Gambar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(128.dp)
            )
            Spacer(modifier.size(4.dp))
            Text(menu.hargaJual.toString())
            Spacer(modifier.size(4.dp))
            Text(text = menu.nama, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Preview
@Composable
fun ProdukCardPrev() {
    EkrafProdukCard(produk = Produk(id = -1))
}