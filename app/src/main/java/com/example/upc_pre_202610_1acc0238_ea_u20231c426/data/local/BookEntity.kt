package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey
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
    @ColumnInfo(name = "is_read")
    val isRead: Boolean
)
