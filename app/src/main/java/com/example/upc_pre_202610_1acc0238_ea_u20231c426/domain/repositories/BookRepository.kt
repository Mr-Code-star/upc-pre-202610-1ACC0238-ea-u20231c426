package com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.repositories

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getBooks(): Flow<List<Book>>

    fun getBooksReads(): Flow<List<Book>>

    suspend fun syncBook()

    suspend fun toggleBookRead(id: Int)
}