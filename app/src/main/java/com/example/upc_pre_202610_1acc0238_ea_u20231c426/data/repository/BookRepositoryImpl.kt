package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.repository

import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.local.BookDao
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.mapper.toDomain
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.mapper.toEntity
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote.BookService
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    val bookService: BookService,
    val bookDao: BookDao
) : BookRepository{
    override fun getBooks(): Flow<List<Book>> {
        return bookDao.getBooks().map { entities  ->
            entities .map { bookEntity ->
                bookEntity.toDomain()
            }
        }
    }

    override fun getBooksReads(): Flow<List<Book>> {
        return bookDao.getBooksReads().map { entities ->
            entities.map { eventEntity ->
                eventEntity.toDomain()
            }
        }
    }

    override suspend fun syncBook() {
        val response = bookService.getBooks()

        if (response.isSuccessful) {
            response.body()?.let { booksResponsesDto ->
                booksResponsesDto.books.map { bookDto ->
                    val localIBook = bookDao.getBooksById(bookDto.id)
                    val entity = bookDto.toEntity(
                        isRead = localIBook?.isRead ?: false
                    )

                    bookDao.upsertBook(entity)
                }
            }
        }
    }

    override suspend fun toggleBookRead(id: Int) {
        return bookDao.toggleRead(id)
    }

}