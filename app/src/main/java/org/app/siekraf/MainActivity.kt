package org.app.siekraf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.app.siekraf.core.navigation.graph.auth.AuthNavGraph
import org.app.siekraf.core.theme.SiEkrafTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            SiEkrafTheme {
                AuthNavGraph(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SiEkrafTheme {
        AuthNavGraph(navController = rememberNavController())
    }
}