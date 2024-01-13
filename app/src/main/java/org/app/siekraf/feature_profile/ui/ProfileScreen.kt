package org.app.siekraf.feature_profile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import org.app.siekraf.core.component.EkrafButton
import org.app.siekraf.core.component.EkrafControlledTextField
import org.app.siekraf.core.component.EkrafDrawerSheet
import org.app.siekraf.core.component.EkrafTextField
import org.app.siekraf.core.component.EkrafTopBar
import org.app.siekraf.core.model.Produk
import org.app.siekraf.core.theme.SkyBlue
import org.app.siekraf.core.utils.ekrafViewModelFactory

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val profileViewModel = viewModel<ProfileViewModel>(factory = ekrafViewModelFactory {
        ProfileViewModel()
    })
    val uiState by profileViewModel.uiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
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
                Surface(shadowElevation = 5.dp) {
                    Column {
                        EkrafTopBar(
                            modifier = modifier
                                .shadow(3.dp),
                            canNavigateBack = false,
                            onLeadingIconClicked = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isOpen) close() else open()
                                    }
                                }
                            },
                            onTrailingIconClicked = {},
                            title = "Profile"
                        )
                    }
                }
            }
        ) { paddingVal ->
            Column(
                modifier = modifier
                    .background(Color.LightGray)
                    .padding(paddingVal)
                    .padding(18.dp)
                    .fillMaxSize(),
                Arrangement.Top,
                Alignment.CenterHorizontally,
            ){
                Image(
                    painter = rememberAsyncImagePainter(Produk(id = 132).gambar),
                    contentDescription = "Gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(128.dp)
                )
                Row (modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Person, contentDescription = "Nama", modifier = Modifier.size(35.dp),
                        tint = SkyBlue
                    )
                    EkrafControlledTextField(
                        labelText = "Nama",
                        showLabel = true,
                        value = uiState.name,
                        onValueChange = { profileViewModel.updateNameInput(it) },
                        hint = {
                            Text("nama")
                        },
                        modifier = modifier.padding(16.dp)
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth(), color = Gray)
                Row (modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email",
                        modifier = Modifier.size(35.dp),
                        tint = SkyBlue
                    )
                    EkrafControlledTextField(
                        labelText = "Email",
                        showLabel = true,
                        value = uiState.email,
                        onValueChange = { profileViewModel.updateEmailInput(it) },
                        hint = {
                            Text("Email")
                        },
                        modifier = modifier.padding(16.dp)
                    )
                }
                Divider(modifier = Modifier.fillMaxWidth(), color = Gray)
                Row (modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Email",
                        modifier = Modifier.size(35.dp),
                        tint = SkyBlue
                    )
                    EkrafPhoneControlledTextField(
                        labelText = "Phone",
                        showLabel = true,
                        value = uiState.phone,
                        onValueChange = { profileViewModel.updatePhoneInput(it) },
                        hint = {
                            Text(
                                81271233899.toString()
                            )
                        },
                        modifier = modifier.padding(16.dp)
                    )
                }
                Spacer(modifier = modifier.size(64.dp))
                EkrafButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(), text = "Simpan")
            }
        }
    }
}

@Composable
fun EkrafPhoneControlledTextField(
    modifier: Modifier = Modifier,
    labelText: String = "",
    value: String,
    isError: Boolean= false,
    onValueChange: (String) -> Unit,
    showLabel: Boolean = true,
    hint: @Composable () -> Unit = {},
    maxLines: Int = 1,
    numberKeyboard: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
        ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (showLabel){
            Text(labelText, style = MaterialTheme.typography.titleLarge)
        }
        OutlinedTextField(
            maxLines = maxLines,
            singleLine = false,
            textStyle = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 2.5.em,
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    ),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Top,
                        trim = LineHeightStyle.Trim.Both,
                    )
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
            ,
            value = value,
            onValueChange = onValueChange,
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color.Black,
                unfocusedBorderColor = Color.LightGray,
                focusedBorderColor = Color.Gray,
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray,
            ),
            isError = isError,
            trailingIcon = {
                if (isError) {
                    Icon(Icons.Filled.Error, "Error")
                }
            },
            leadingIcon = {
                          Text("+62")

            },
            placeholder = hint,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
        )
    }
}

@Preview
@Composable
fun PSPrev() {
    ProfileScreen()
}