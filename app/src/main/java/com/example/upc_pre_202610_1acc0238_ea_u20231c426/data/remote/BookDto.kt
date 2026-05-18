package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote

data class BookDto(
    val id: Int,
    val title: String,
    val author: String,
    val cover: String,
    val publisher: String? = "",      // Puede ser null
    val year: Int? = 0,               // Puede ser null
    val rating: Double? = 0.0,        // Puede ser null
    val gender: String? = "",         // Puede ser null - ¡Este es el que causa el error!
    val overview: String? = ""        // Puede ser null
)