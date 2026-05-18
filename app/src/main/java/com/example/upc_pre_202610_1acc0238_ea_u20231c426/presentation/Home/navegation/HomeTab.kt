package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.navegation

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.R

enum class HomeTab(
    val label: String,
    val icon: Int,
    val iconFilled: Int
) {
    Books(
        label = "Books",
        icon = R.drawable.libros,
        iconFilled =R.drawable.books_filled
    ),

    Bibloteca(
        label = "Bibloteca",
        icon = R.drawable.bibloteca,
        iconFilled = R.drawable.bibliteca_filled
    )

}