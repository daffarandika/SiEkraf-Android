package org.app.siekraf.feature_belanja.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import org.app.siekraf.core.component.EkrafProdukCard
import org.app.siekraf.core.model.Produk

@Composable
fun ProdukList(produks: List<Produk>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items (produks) {produk ->
            EkrafProdukCard(produk = produk)
        }
    }
}

