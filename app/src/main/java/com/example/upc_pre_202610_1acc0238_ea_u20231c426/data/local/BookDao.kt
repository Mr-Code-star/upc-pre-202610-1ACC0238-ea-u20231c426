package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM books WHERE is_read = 1")
    fun getBooksReads(): Flow<List<BookEntity>>

    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun getBooksById(id: Int): BookEntity?

    @Upsert
    suspend fun upsertBook(book: BookEntity)

    @Query("update books set is_read = not is_read where id =:id")
    suspend fun toggleRead(id: Int)
}