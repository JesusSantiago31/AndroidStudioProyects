package com.tesji.botones6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tesji.botones6.ui.theme.Botones6Theme


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var rojo by remember { mutableStateOf(0) }
    var verde by remember { mutableStateOf(0) }
    var azul by remember { mutableStateOf(0) }
    Column() {
        LazyRow() {
            items(256) { indice ->
                Button (
                    shape = RoundedCornerShape(0),
                    modifier = Modifier.height(100.dp),
                    onClick = {
                        rojo = indice
                    },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color(indice, 0, 0),
                    )
                )
                {
                    Text(text = "$indice",color= Color.White)
                }
            }
        }
        LazyRow() {
            items(256) { indice ->Button(
                shape = RoundedCornerShape(0),
                modifier = Modifier.height(100.dp),
                onClick = { verde = indice },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0, indice, 0),
                )
            )
            {
                Text(text = "$indice",color= Color.White)
            }
            }
        }
        LazyRow() {
            items(256) { indice ->
                Button(
                    shape = RoundedCornerShape(0),
                    modifier = Modifier.height(100.dp),
                    onClick = { azul = indice },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color(0, 0, indice),
                    )
                )
                {
                    Text(text = "$indice",color= Color.White)
                }
            }
        }
        Button(
            shape = RoundedCornerShape(0),
            modifier = Modifier.fillMaxSize(),
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(rojo, verde, azul),
            )
        )
        {
            Column() {
                SelectionContainer {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "rgb($rojo,$verde,$azul)", fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color(255-rojo,255-verde,255-azul)
                    )
                }
                SelectionContainer() {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "#${rojo.toString(16).padStart(2, '0').uppercase()}${
                            verde.toString(16).padStart(2, '0').uppercase()
                        }${azul.toString(16).padStart(2, '0').uppercase()}", fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color(255-rojo,255-verde,255-azul))
                }
            }
        }
    }
}