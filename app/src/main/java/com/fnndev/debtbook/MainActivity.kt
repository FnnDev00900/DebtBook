package com.fnndev.debtbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fnndev.debtbook.presentation.ui.screens.main_menu.MainMenuScreen
import com.fnndev.debtbook.presentation.ui.theme.DebtBookTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DebtBookTheme {
                MainMenuScreen()
            }
        }
    }
}