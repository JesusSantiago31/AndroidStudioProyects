package com.tesji.composable3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tesji.composable3.ui.theme.Composable3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatrizIdentidad()
        }
    }
}

@Composable
fun MatrizIdentidad() {
    Column {
        for(fil in 1..10)
            Row {
                for(col in 1..10) {
                    if (fil==col)
                        Text(text = " 1 ")
                    else
                        Text(text = " 0 ")
                }
            }
    }
}