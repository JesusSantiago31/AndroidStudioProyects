package com.tesji.figurascanvas9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tesji.figurascanvas9.ui.theme.FigurasCanvas9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipal()
        }
    }
}
@Composable
fun PantallaPrincipal() {
    Canvas (modifier = Modifier.fillMaxSize()) {
        val ancho = size.width
        val alto = size.height
        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = ancho, y = alto),
            color = Color.Red,
            strokeWidth = 10f
        )
        drawLine(
            start = Offset(x = ancho, y = 0f),
            end = Offset(x = 0f, y = alto),
            color = Color.Red,
            strokeWidth = 10f
        )
        drawCircle(
            center = Offset(x = ancho / 2, y = alto / 2),
            radius = ancho / 10,
            color = Color.Yellow
        )
        drawRect(
            topLeft = Offset(x = 0f, y = 0f),
            size = Size(ancho*0.50f, alto*0.10f),
            color = Color.Green
        )
    }
}