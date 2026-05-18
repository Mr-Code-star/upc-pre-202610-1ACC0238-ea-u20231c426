package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation.BookNavHost
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation.BookReadNavHost

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation.HomeTab

@Composable
fun HomeView(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state.collectAsState().value
    var selectedTab by rememberSaveable {
        mutableStateOf(HomeTab.Books)
    }

    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.errorMessage){
        state.errorMessage?.let { message ->
            snackBarHostState.showSnackbar(message)
            viewModel.clearError()
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Scaffold(
            bottomBar = {
                NavigationBar {
                    HomeTab.entries.forEach { tab ->
                        val selected = selectedTab == tab

                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                selectedTab = tab
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(if(selected) tab.iconFilled else tab.icon),
                                    contentDescription = tab.label,
                                    tint = if(selected) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            label = {
                                Text(tab.label)
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                when (selectedTab) {
                    HomeTab.Books -> BookNavHost()
                    HomeTab.Bibloteca -> BookReadNavHost()
                    else -> Text(text = selectedTab.label)

                }
            }
        }
    }

}