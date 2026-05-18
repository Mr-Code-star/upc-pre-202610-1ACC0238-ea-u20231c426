package com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.Home.books

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.R
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.domain.model.Book

@Composable
fun BookDetail(
    book: Book,
    isRead: Boolean,
    onToggleRead: () -> Unit = {}
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                ) {
                    AsyncImage(
                        model = book.image,
                        contentDescription = book.title,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    IconButton(
                        onClick = onToggleRead,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp)
                            .size(40.dp)
                            .background(Color.White, shape = CircleShape)
                    ) {
                        if (isRead) {  // Usar el estado observado
                            Icon(
                                painter = painterResource(R.drawable.read),
                                contentDescription = "Unmark as Read",
                                tint = Color.Unspecified
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.read_filled),
                                contentDescription = "Mark as Read",
                                tint = Color.Unspecified
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                }
                Column (modifier = Modifier.padding(16.dp)){
                    Text(
                        text = "Titulo: ${book.title}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Autor: ${book.author}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Editorial: ${book.editorial}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Genero: ${book.gender}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Sinopsis: ${book.overview}",
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "⭐ Rating: ${book.rating}",
                        fontSize = 16.sp,
                    )

                }
            }
        }
    }
}