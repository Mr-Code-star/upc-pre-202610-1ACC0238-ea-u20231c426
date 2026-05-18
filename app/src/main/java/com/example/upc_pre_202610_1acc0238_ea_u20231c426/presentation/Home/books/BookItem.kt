package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book

@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(8.dp)){
            AsyncImage(
                model = book.image,
                contentDescription = book.title,
                modifier = Modifier
                    .height(256.dp)
                    .fillMaxWidth()
            )

            Text(
                text = book.title,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Autor: ${book.author}",
            )

            Text(
                text = "Año de Publicacion: ${book.yearPublisher}",
            )
        }
    }
}