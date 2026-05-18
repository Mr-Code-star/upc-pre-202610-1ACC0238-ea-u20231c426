package com.example.upc_pre_202610_1acc0238_ea_u20231c426.data.remote

import com.google.gson.annotations.SerializedName

data class BooksResponsesDto(
    val count: Int,
    @SerializedName("results")
    val books: List<BookDto>
)
