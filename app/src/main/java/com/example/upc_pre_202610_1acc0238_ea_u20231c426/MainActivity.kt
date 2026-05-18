package com.example.upc_pre_202610_1acc0238_ea_u20231c426

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.upc_pre_202610_1acc0238_ea_u20231c426.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                // Hacemos prueba si funcion todo bien cosa que si todo esta funcionando correcto
                // con las dependencias y configuraciones
                // Bueno Vitaly del futuro buen examen (Tranquilo, no te extreses todo saldra bien)
                Main()
            }
        }
    }
}

/**
 * Es un Main de Hello Wordl este main no va ser importante en el examen
 */
@Composable
fun Main() {
    Box(
        modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
        contentAlignment = Alignment.Center // Centra el contenido
    ) {
        Text(
            text = "Hello World",
            fontSize = 24.sp
        )
    }
}

/**
 * Guiate del Examen de repositorio que hicistes ayer vitaly
 * link: https://github.com/Mr-Code-star/upc-pre-202510-1acc0238-ea-u20231c426.git
 */