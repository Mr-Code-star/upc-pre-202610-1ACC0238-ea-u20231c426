package com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val image: String,
    val yearPublisher: Int,
    val gender: String,
    val rating: Double,
    val overview: String,
    val editorial: String,
    /**
     * Indica si el libro fue marcado como leido
     */
    val isRead: Boolean
)
