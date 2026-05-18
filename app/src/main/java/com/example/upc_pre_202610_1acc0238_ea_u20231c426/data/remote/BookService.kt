package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface BookService {
    @GET("books")
    suspend fun getBooks(): Response<BooksResponsesDto>
}