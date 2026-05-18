package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.HomeViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun ReadBookScreen(
    viewModel: HomeViewModel,
    onRemoveRead: (Int) -> Unit,
    onEventClick: (Book) -> Unit
) {
    val state = viewModel.state.collectAsState().value

    val snackbarHostState = remember { SnackbarHostState() }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ){
        when {
            state.readsBooks.isNotEmpty() -> {
                LazyColumn {
                    items(state.readsBooks) { readBook ->
                        ReadBookItem(
                            readBook,
                            onClick = { onEventClick(readBook) },
                            onRemove = { onRemoveRead(readBook.id) }
                        )
                    }
                }
            }

            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No events available")
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}