package org.app.siekraf.feature_belanja.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.component.EkrafProdukCard
import org.app.siekraf.core.component.EkrafSecondaryTopBar
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.model.KategoriProduk
import org.app.siekraf.core.model.Produk
import org.app.siekraf.core.navigation.Screen
import kotlin.reflect.KParameter

@Composable
fun BelanjaScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var activeIndex by remember{
        mutableIntStateOf(0)
    }
    var selectedKategori by remember {
        mutableStateOf(KategoriProduk(activeIndex))
    }
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
                    EkrafSecondaryTopBar(
                        items = listOf((
                            BarNavigationItem(text = "Kerajinan", screen = Screen.Home, icon = {})),
                            BarNavigationItem(text = "Meubel", screen = Screen.Notification, icon = {}),
                            BarNavigationItem(text = "Kuliner", screen = Screen.KotakSaran, icon = {}),
                            BarNavigationItem(text = "Gula Jawa", screen = Screen.Profile, icon = {}),
                            BarNavigationItem(text = "Konveksi", screen = Screen.Profile, icon = {})
                        ),
                        navController = navController,
                        activeIndex = activeIndex,
                        modifier = modifier.shadow(10.dp),
                        onActiveIndexChanged = { id ->
                            selectedKategori = Produk.getKategoriById(id)
                            activeIndex = id
                        }
                    )
                }
            }
        }
    ) {
        Column(modifier.padding(it)){
            val produks = listOf(
                Produk(id = 1, kategori = KategoriProduk.kerajinan),
                Produk(id = 2, kategori = KategoriProduk.kerajinan),
                Produk(id = 3, kategori = KategoriProduk.kerajinan),
                Produk(id = 4, kategori = KategoriProduk.kerajinan),
                Produk(id = 5, kategori = KategoriProduk.kerajinan),
                Produk(id = 6, kategori = KategoriProduk.meubel),
                Produk(id = 7, kategori = KategoriProduk.meubel),
                Produk(id = 8, kategori = KategoriProduk.meubel),
                Produk(id = 9, kategori = KategoriProduk.meubel),
                Produk(id = 10, kategori = KategoriProduk.meubel),
                Produk(id = 11, kategori = KategoriProduk.meubel),
                Produk(id = 12, kategori = KategoriProduk.kuliner),
                Produk(id = 13, kategori = KategoriProduk.kuliner),
                Produk(id = 14, kategori = KategoriProduk.kuliner),
                Produk(id = 15, kategori = KategoriProduk.kuliner),
                Produk(id = 16, kategori = KategoriProduk.kuliner),
                Produk(id = 17, kategori = KategoriProduk.kuliner),
                Produk(id = 18, kategori = KategoriProduk.kuliner),
                Produk(id = 19, kategori = KategoriProduk.gulaJawa),
                Produk(id = 20, kategori = KategoriProduk.gulaJawa),
                Produk(id = 21, kategori = KategoriProduk.gulaJawa),
                Produk(id = 22, kategori = KategoriProduk.konveksi),
            )
             val filteredProduk = produks.filter { produk ->
                produk.kategori == selectedKategori
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items (filteredProduk) {produk ->
                    EkrafProdukCard(
                        produk = produk,
                        onClick = {
                            navController.navigate(Screen.ProductDetail.passProductId(produk.id.toString()))
                        }
                    )
                }
            }
        }
    }
}