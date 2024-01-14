package org.app.siekraf.feature_menu.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import org.app.siekraf.core.component.EkrafMenuCard
import org.app.siekraf.core.component.EkrafProdukCard
import org.app.siekraf.core.component.EkrafSecondaryTopBar
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.model.BarNavigationItem
import org.app.siekraf.core.model.KategoriMenu
import org.app.siekraf.core.model.KategoriProduk
import org.app.siekraf.core.model.Menu
import org.app.siekraf.core.model.Produk
import org.app.siekraf.core.navigation.Screen

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var activeIndex by remember{
        mutableIntStateOf(0)
    }
    var selectedKategori by remember {
        mutableStateOf(KategoriMenu(activeIndex))
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
                            BarNavigationItem(text = "Kesenian Tradisional", screen = Screen.Notification, icon = {})),
                            BarNavigationItem(text = "Tiket Wisata", screen = Screen.Home, icon = {})
                        ),
                        navController = navController,
                        activeIndex = activeIndex,
                        modifier = modifier,
                        onActiveIndexChanged = { id ->
                            selectedKategori = Menu.getKategoriById(id)
                            activeIndex = id
                        }
                    )
                }
            }
        }
    ) {
        Column(modifier.padding(it)){
            val menus = listOf(
                Menu(id = 1, kategori = KategoriMenu.kesenian),
                Menu(id = 2, kategori = KategoriMenu.kesenian),
                Menu(id = 3, kategori = KategoriMenu.kesenian),
                Menu(id = 4, kategori = KategoriMenu.kesenian),
                Menu(id = 5, kategori = KategoriMenu.kesenian),
                Menu(id = 6, kategori = KategoriMenu.wisata),
                Menu(id = 7, kategori = KategoriMenu.wisata),
                Menu(id = 8, kategori = KategoriMenu.wisata),
                Menu(id = 9, kategori = KategoriMenu.wisata),
                Menu(id = 10, kategori = KategoriMenu.wisata),
                Menu(id = 11, kategori = KategoriMenu.wisata),
            )
            val filteredMenu = menus.filter { menu ->
                menu.kategori == selectedKategori
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
            ) {
                items (filteredMenu) {menu ->
                    EkrafMenuCard(
                        menu = menu,
                        onClick = {
                            navController.navigate(Screen.ProductDetail.passProductId(menu.id.toString()))
                        }
                    )
                }
            }
        }
    }
}
