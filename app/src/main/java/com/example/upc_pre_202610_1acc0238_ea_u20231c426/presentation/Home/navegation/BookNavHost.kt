package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.HomeViewModel
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books.BookDetail
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books.BookList

@Composable
fun BookNavHost(){
    val viewModel: HomeViewModel = viewModel()

    val selectedBook = remember {
        mutableStateOf<Book?>(null)
    }

    val navController = rememberNavController()

    val state by viewModel.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = "Books"
    ) {
        composable("Books") {
            BookList(viewModel) { book ->
                selectedBook.value = book
                navController.navigate("book_detail")
            }
        }

        composable("book_detail") {
            selectedBook.value?.let {  book ->
                val isRead = state.readsBooks.any {it.id == book.id}

                BookDetail(
                    book = book,
                    isRead = isRead,
                    onToggleRead = {
                        viewModel.toggleBookRead(book.id)
                    }
                )

            }
        }
    }
}
