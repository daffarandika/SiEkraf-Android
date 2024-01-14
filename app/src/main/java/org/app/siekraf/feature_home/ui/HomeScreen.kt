package org.app.siekraf.feature_home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material.icons.outlined.ShoppingBasket
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.component.EkrafAspirasiCard
import org.app.siekraf.core.component.EkrafDrawerSheet
import org.app.siekraf.core.component.EkrafImageTextButton
import org.app.siekraf.core.model.Aspirasi
import org.app.siekraf.core.navigation.Screen
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val density = LocalDensity.current

    viewModel.updateAspirasi(
        listOf(
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
            Aspirasi(judul="Biografi Linus Torvalds, Pencipta Linux Sebagai Tulang Punggung Internet", poster = "post", isi = "isi", tanggal = "12 desember 2005"),
        )
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                EkrafDrawerSheet()
            }
        },
    ){
        Scaffold(
            topBar = {
                Surface(shadowElevation = 3.dp) {
                    EkrafTopBar(title = "", canNavigateBack = false, onLeadingIconClicked = {
                        scope.launch{
                            drawerState.apply {
                                if (isOpen) close() else open()
                            }
                        }
                    })
                }
            },
        ) {
            Column (
                modifier
                    .fillMaxWidth()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = modifier
                        .padding(9.dp)
                        .fillMaxWidth(0.9f)
                        .height(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(LightGray)
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(16.dp),
                            color = Color(0xff696969)
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row (modifier = Modifier.padding(8.dp)){
                        Icon(imageVector = Icons.Filled.Wallet, tint= SkyBlue, contentDescription = null)
                        Spacer(Modifier.size(4.dp))
                        Text(uiState.saldo.toString())
                    }
                    Row (horizontalArrangement = Arrangement.spacedBy(4.dp)){
                        EkrafImageTextButton(text = "Bayar", onClick = {}) {
                            Icon(Icons.Filled.ArrowUpward, null,
                                Modifier
                                    .drawBehind {
                                        drawRoundRect(
                                            color = SkyBlue,
                                            size = Size(
                                                width = this.size.maxDimension * 1.5f,
                                                height = this.size.maxDimension * 0.95f
                                            ),
                                            cornerRadius = CornerRadius(18.dp.toPx())
                                        )
                                    }
                                    .offset(x = 5.dp), tint = Color.White)
                        }
                        EkrafImageTextButton(text = "Riwayat", onClick = {}) {
                            Icon(Icons.Filled.History, null, Modifier.drawBehind {
                            }, tint = SkyBlue)
                        }
                        EkrafImageTextButton(text = "Tambah\n Produk", onClick = {}) {
                            Icon(Icons.Filled.Add, null, Modifier.drawBehind {
                            }, tint = SkyBlue)
                        }
                        Spacer(modifier.size(8.dp))
                    }
                }
                Row(Modifier.fillMaxWidth(), Arrangement.Center) {
                    HomeChip(icon = Icons.Outlined.MenuBook, text = "Menu",
                        onClick = {
                            navController.navigate(Screen.Menu.route)
                        }
                    )
                    HomeChip(icon = Icons.Outlined.Book, text = "Buku Keuangan")
                    HomeChip(icon = Icons.Outlined.ShoppingBasket, text = "Belanja",
                            onClick = {
                                navController.navigate(Screen.Belanja.route)
                        }
                    )
                    HomeChip(icon = Icons.Outlined.QueryStats, text = "Traffic")
                    HomeChip(icon = Icons.Outlined.CardGiftcard, text = "Reward")
                }
                Text(text = "Kotak Aspirasi", style = MaterialTheme.typography.headlineLarge, modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.Start))
                LazyRow (
                    content = {
                        items(uiState.listApsirasi) {
                            EkrafAspirasiCard(it)
                        }
                    }
                )
            }
        }

    }
}