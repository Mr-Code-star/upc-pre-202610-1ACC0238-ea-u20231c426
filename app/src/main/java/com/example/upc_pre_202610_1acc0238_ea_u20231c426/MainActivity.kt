package com.example.upc_pre_202610_1acc0238_ea_u20231c426

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.HomeView
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    HomeView(viewModel(), modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}

