package org.app.siekraf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.app.siekraf.core.navigation.graph.auth.AuthNavGraph
import org.app.siekraf.core.theme.SiEkrafTheme
import org.app.siekraf.feature_auth.ui.LoginScreen
import org.app.siekraf.feature_auth.ui.LoginViewModel
import org.app.siekraf.feature_home.ui.HomeViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            SiEkrafTheme {
                val loginViewModel: LoginViewModel by viewModels()
                val homeViewModel: HomeViewModel by viewModels()
                AuthNavGraph(navController = navController, loginViewModel = loginViewModel, homeViewModel = homeViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SiEkrafTheme {
        LoginScreen()
    }
}