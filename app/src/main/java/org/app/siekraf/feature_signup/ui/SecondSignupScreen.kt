package org.app.siekraf.feature_signup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.app.siekraf.R
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafPhoneTextField
import org.app.siekraf.core.component.EkrafRadioButton
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.theme.SkyBlue

@Composable
fun SecondSignupScreen(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = SignupViewModel(),
    navController: NavHostController
) {

    val uiState = viewModel.uiState.collectAsState()

    val signupState by remember { viewModel.signupState }.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_siekraf),
            contentDescription = "Logo",
            modifier = Modifier
                .size(98.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.size(16.dp))
        Text("Daftar", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(Modifier.size(16.dp))

        EkrafRadioButton(
            label = "Jenis Kelamin",
            list = uiState.value.genderRadioValue,
            selectedIndex = uiState.value.selectedGenderRadioIndex,
            onSelectedChanged = {viewModel.updateGenderRadioIndex(it)},
            modifier = Modifier.align(Alignment.Start)
        )

        EkrafRadioButton(
            label = "Peran",
            list = uiState.value.roleRadioValue,
            selectedIndex = uiState.value.selectedRoleRadioIndex,
            onSelectedChanged = {viewModel.updateRoleRadioIndex(it)},
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(Modifier.size(10.dp))

        EkrafPhoneTextField(
            value = uiState.value.email,
            onValueChange = {viewModel.updateEmailInput(it)},
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.value.isEmailError
        )

        Spacer(Modifier.size(10.dp))

        EkrafTextField(
            maxLines=5,
            value = uiState.value.password,
            isError = uiState.value.isPasswordError,
            hint = {
                Column(verticalArrangement = Arrangement.Top){
                    Text("Alamat", color = Color.LightGray)
                    Spacer(modifier.size(90.dp))
                }
            },
            onValueChange = { viewModel.updatePasswordInput(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.ArrowRightAlt,
                    contentDescription = "Next",
                    modifier = Modifier
                        .size(100.dp)
                        .rotate(180f)
                )
            }
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(0.30f))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(SkyBlue)
                    .size(16.dp),
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .size(16.dp),
            )
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(0.8f))

        }

        EkrafButton(
            onClick = {},
            text = "Login",
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
@Preview(widthDp = 375, heightDp = 812)
@Composable
private fun FirstSignupScreenPreview() {
    SecondSignupScreen(
        Modifier
            .width(375.dp)
            .height(812.dp)
            .background(color = Color(0xFFFFFFFF)),
        navController = rememberNavController()
    )
}
