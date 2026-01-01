package com.fnndev.debtbook.presentation.ui.screens.person.add_edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.fnndev.debtbook.R
import com.fnndev.debtbook.presentation.ui.theme.VazirMatnFont

@Composable
fun AddOrEditPersonScreen(
    viewModel: AddEditPersonViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding() + 3.dp,
                    bottom = innerPadding.calculateBottomPadding() + 3.dp,
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr) + 3.dp,
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr) + 3.dp
                ),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CompositionLocalProvider(value = LocalLayoutDirection provides LayoutDirection.Rtl) {

                    Image(
                        painter = painterResource(R.drawable.ic_add_person),
                        contentDescription = "Add person",
                        modifier = Modifier.size(300.dp)
                    )

                    OutlinedTextField(
                        value = state.value.personFullName,
                        onValueChange = { viewModel.onEvent(AddEditPersonEvent.OnFullNameChange(it)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        placeholder = {
                            Text(
                                text = "نام و نام خانوادگی",
                                style = TextStyle(fontFamily = VazirMatnFont)
                            )
                        },
                        label = {
                            Text(
                                text = "نام و نام خانوادگی",
                                style = TextStyle(fontFamily = VazirMatnFont)
                            )
                        },
                        singleLine = true, maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ), textStyle = TextStyle(fontFamily = VazirMatnFont)
                    )
                    OutlinedTextField(
                        value = state.value.personMobile,
                        onValueChange = { viewModel.onEvent(AddEditPersonEvent.OnMobileChange(it)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        placeholder = { Text(text = "شماره تماس") },
                        label = { Text(text = "شماره تماس") },
                        singleLine = true, maxLines = 1,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        )
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        Text(text = "افزودن شخص", style = TextStyle(fontFamily = VazirMatnFont))
                    }
                }
            }
        }
    }
}