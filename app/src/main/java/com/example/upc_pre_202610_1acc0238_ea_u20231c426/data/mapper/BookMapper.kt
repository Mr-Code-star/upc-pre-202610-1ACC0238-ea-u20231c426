package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.mapper

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local.BookEntity
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote.BookDto
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book

fun BookDto.toEntity(isRead: Boolean): BookEntity {
    return BookEntity(
        id = this.id,
        title = this.title,
        author = this.author,
        image = this.cover,
        yearPublisher = this.year ?: 0,           // Valor por defecto si es null
        gender = this.gender ?: "Género no especificado", // Valor por defecto
        rating = this.rating ?: 0.0,              // Valor por defecto
        overview = this.overview ?: "Sin descripción disponible",
        editorial = this.publisher ?: "Editorial no especificada",
        isRead = isRead
    )
}

fun BookEntity.toDomain(): Book {
    return Book(
        id = this.id,
        title = this.title,
        author = this.author,
        image = this.image,
        yearPublisher = this.yearPublisher,
        gender = this.gender,
        rating = this.rating,
        overview = this.overview,
        editorial = this.editorial,
        isRead = this.isRead
    )
}