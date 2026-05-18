package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.repositories.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository
): ViewModel(){

    val state = MutableStateFlow(HomeState())

    fun observeBooks() {
        viewModelScope.launch {
            bookRepository.getBooks().collect { books ->
                state.update {
                    it.copy(books = books)
                }
            }
        }
    }

    fun syncBooks() {
        state.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            try {
                bookRepository.syncBook()
                state.update {
                    it.copy(isLoading = false)
                }
            } catch (_: UnknownHostException){
                state.update {
                    it.copy(isLoading = false, errorMessage = "No hay internet")
                }
            } catch (e: Exception){
                state.update {
                    it.copy(isLoading = false, errorMessage = e.message ?: "An error occurred")
                }
            }
        }
    }

    fun observeReadsBooks() {
        viewModelScope.launch {
            bookRepository.getBooksReads().collect { reads ->
                state.update { it.copy(readsBooks = reads) }
            }
        }
    }

    fun toggleBookRead(id: Int) {
        viewModelScope.launch {
            try {
                bookRepository.toggleBookRead(id)
            } catch (e: Exception) {
                state.update {
                    it.copy(errorMessage = "Error al actualizar leído")
                }
            }
        }
    }

    fun removeFromRead(id: Int) {
        viewModelScope.launch {
            try {
                val currentState = state.value
                val isFavorite = currentState.readsBooks.any { it.id == id }
                if (isFavorite) {
                    bookRepository.toggleBookRead(id)
                }
            } catch (e: Exception) {
                state.update {
                    it.copy(errorMessage = "Error al eliminar un libro leído")
                }
            }
        }
    }

    fun clearError() {
        state.update {
            it.copy(errorMessage = null)
        }
    }

    init {
        observeBooks()
        observeReadsBooks()
        syncBooks()
    }
}