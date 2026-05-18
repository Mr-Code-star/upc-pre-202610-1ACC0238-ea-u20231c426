package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book

data class HomeState(
    val books: List<Book> = emptyList(),

    val isLoading: Boolean = false,

    val errorMessage: String? = null,

    val readsBooks: List<Book> = emptyList(),

    )
