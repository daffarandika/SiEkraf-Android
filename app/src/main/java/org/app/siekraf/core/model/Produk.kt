package org.app.siekraf.core.model

open class KategoriProduk(id: Int) {
    object kuliner: KategoriProduk(0)
    object meubel: KategoriProduk(1)
    object kerajinan: KategoriProduk(2)
    object gulaJawa: KategoriProduk(3)
    object konveksi:  KategoriProduk(4)
}
open class KategoriMenu(id: Int) {
    object kesenian: KategoriMenu(0)
    object wisata: KategoriMenu(1)
}


data class Menu(
    val id: Int,
    val nama: String = "Nama",
    val gambar: String = "https://images-cdn.ubuy.co.id/64173723af597072b7233682-soldering-gun-100w-lcd-digital-solder.jpg",
    val deskripsi: String = "Deskripsi",
    val hargaJual: Float = -1f,
    val hargaPokok: Float = -1f,
    val beban: Float = 0f,
    val penjual: String = "Bagus",
    val stok: Int = 9,
    val kategori: KategoriMenu = KategoriMenu.kesenian,
) {
    companion object {
        fun getKategoriById(id: Int) : KategoriMenu {
            return when (id) {
                0 -> KategoriMenu.kesenian
                else -> KategoriMenu.wisata
            }
        }
    }
}

data class Produk(
    val id: Int,
    val nama: String = "Nama",
    val gambar: String = "https://images-cdn.ubuy.co.id/64173723af597072b7233682-soldering-gun-100w-lcd-digital-solder.jpg",
    val deskripsi: String = "Deskripsi",
    val hargaJual: Float = -1f,
    val hargaPokok: Float = -1f,
    val beban: Float = 0f,
    val penjual: String = "Bagus",
    val stok: Int = 9,
    val kategori: KategoriProduk = KategoriProduk.kuliner,
) {
    companion object {
        fun getKategoriById(id: Int) : KategoriProduk {
            return when (id) {
                0 -> KategoriProduk.kerajinan
                1 -> KategoriProduk.meubel
                2 -> KategoriProduk.kuliner
                3 -> KategoriProduk.gulaJawa
                else -> KategoriProduk.konveksi
            }
        }
    }
}
