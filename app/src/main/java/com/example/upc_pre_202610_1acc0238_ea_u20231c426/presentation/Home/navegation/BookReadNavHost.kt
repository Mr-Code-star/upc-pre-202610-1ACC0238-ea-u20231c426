package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.HomeViewModel
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books.ReadBookDetail
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books.ReadBookScreen

@Composable
fun BookReadNavHost(){
    val viewModel: HomeViewModel = viewModel()

    val selectedBook = remember {
        mutableStateOf<Book?>(null)
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Bibloteca"
    ){
        composable("Bibloteca"){
            ReadBookScreen(
                viewModel = viewModel,
                onRemoveRead = { id ->
                    viewModel.toggleBookRead(id)
                },
                onEventClick = { book ->
                    selectedBook.value = book
                    navController.navigate("detail_read")
                }
            )
        }
        composable("detail_read") {
            selectedBook.value?.let { book ->
                ReadBookDetail(bo = book)
            }
        }
    }
}