package org.app.siekraf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.app.siekraf.core.theme.SiEkrafTheme
import org.app.siekraf.feature_login.ui.LoginScreen
import org.app.siekraf.feature_signup.ui.FirstSignupScreen
import org.app.siekraf.feature_signup.ui.SecondSignupScreen
import org.app.siekraf.feature_signup.ui.SignupViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = viewModel<SignupViewModel>()
            SiEkrafTheme {
                SecondSignupScreen(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color(0xFFFFFFFF)),
                    viewModel = viewModel
                )
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
        SecondSignupScreen(
            modifier = Modifier
                .padding(16.dp)
                .background(color = Color(0xFFFFFFFF)),
        )
    }
}