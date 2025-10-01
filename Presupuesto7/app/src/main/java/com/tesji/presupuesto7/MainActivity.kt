package com.tesji.presupuesto7

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
import com.tesji.presupuesto7.ui.theme.Presupuesto7Theme


import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Presupuesto(productos)
        }
    }
}
@Composable
fun Presupuesto(productos: List<Producto>) {
    var monto by rememberSaveable { mutableStateOf(0) }
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(10.dp)) {
            Text(text = "Presupuesto Actual:", fontSize = 25.sp)
            Text(text = "$monto", fontSize = 25.sp, color = Color.Red)
        }
        Divider(
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .width(5.dp)
        )
        LazyColumn() {
            items(productos) { producto ->
                ListadoProducto(producto, seleccionProducto = {monto = monto + it
                })
            }
        }
    }
}
@Composable
fun ListadoProducto(producto: Producto, seleccionProducto: (Int) -> Unit) {
    var seleccionado by rememberSaveable { mutableStateOf(false) }
    Row() {
        Checkbox(
            checked = seleccionado,
            onCheckedChange = {
                seleccionado = it
                if (it)
                    seleccionProducto(producto.precio)
                else
                    seleccionProducto(-producto.precio)
            },
            modifier = Modifier.padding(10.dp),
        )
        Column() {
            Text(text = "${producto.nombre} (${producto.precio})", fontSize = 20.sp)
            Image(painter = painterResource(id = producto.imagen), contentDescription = null)
        }
    }
    Divider(
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )
}
data class Producto(val nombre: String, val precio: Int, val imagen: Int)
val productos = listOf<Producto>(
    Producto("I9", 70000, R.drawable.i7),
    Producto("I5", 50000, R.drawable.i5),
    Producto("I3", 35000, R.drawable.i3),
    Producto("Placa A", 46000, R.drawable.placa1),
  
)