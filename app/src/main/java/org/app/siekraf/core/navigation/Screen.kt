package org.app.siekraf.core.navigation

const val MAIN_GRAPH_ROUTE = "MAIN"
const val AUTH_GRAPH_ROUTE = "AUTH"
const val HOME_GRAPH_ROUTE = "HOME"
const val PROFILE_GRAPH_ROUTE = "PROFILE"
const val FORUM_GRAPH_ROUTE = "FORUM"
const val CART_GRAPH_ROUTE = "CART"
const val QR_GRAPH_ROUTE = "QR"
const val BELANJA_GRAPH_ROUTE = "BELANJA"


sealed class Screen(val route: String) {
    object Login: Screen("login")
    object FirstSignUp: Screen("sign_up")
    object SecondSignUp: Screen("sign_up")
    object Main: Screen("main")
    object Home: Screen("home")
    object QrCode: Screen("qr_code")
    object ProductDetail: Screen("product_detail") {
        fun passProductId(productId: String): String {
            return "product_detail/$productId"
        }
    }
    object Cart: Screen("cart")
    object Profile: Screen("profile")
    object KotakSaran: Screen("saran")
    object AddSaran: Screen("add_saran")
    object Scan: Screen("scan")
    object Belanja: Screen("shopping")
    object Notification: Screen("notification")
    object Traffic: Screen("traffic")
}