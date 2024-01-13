package org.app.siekraf.feature_product_detail.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafCounter
import org.app.siekraf.core.component.EkrafProdukCard
import org.app.siekraf.core.component.EkrafSecondaryTopBar
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.model.KategoriProduk
import org.app.siekraf.core.model.Produk

val TAG = "detail cok"

@Composable
fun ProductDetailScreen(modifier: Modifier = Modifier, id: String, navController: NavHostController) {
    var number by remember {
        mutableIntStateOf(0)
    }
    val produk = Produk(id = 1)
    Log.i(TAG, "ProductDetailScreen: ${navController.currentBackStackEntry?.destination?.route}")
    Scaffold (
        topBar = {
            Surface(shadowElevation = 5.dp) {
                Column {
                    EkrafTopBar(
                        modifier = modifier
                            .shadow(3.dp),
                        canNavigateBack = true,
                        onLeadingIconClicked = {
                            navController.popBackStack()
                        },
                        onTrailingIconClicked = {},
                        title = "Belanja"
                    )
                }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it).padding(10.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(produk.gambar),
                    contentDescription = "Gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(128.dp),
                )
                Text(produk.nama, style = MaterialTheme.typography.titleSmall)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Stok: ${produk.stok}", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = produk.deskripsi, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = produk.hargaJual.toString(), style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier.size(18.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                EkrafCounter(
                    number = number,
                    onIncrement = {
                        number++
                    },
                    onDecrement = {
                        number = if (number == 0) 0
                            else --number
                    }
                )
                EkrafButton(onClick = { /*TODO*/ }, text = "Tambah ke keranjang", modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview
@Composable
fun PDSPref() {
    ProductDetailScreen(id = "0", navController = rememberNavController())
}