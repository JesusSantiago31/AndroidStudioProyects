// Importamos el paquete principal de Flutter con widgets de Material Design
import 'package:flutter/material.dart';

// La función principal de Dart, siempre es el punto de entrada de la app
void main() {
  // runApp() arranca la aplicación y muestra en pantalla el widget raíz
  runApp(MyApp());
}

// Creamos la clase principal de la app
// StatelessWidget significa que este widget no cambia su estado (es estático)
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // MaterialApp es el contenedor base con estilo Material Design (Android/Google)
    return MaterialApp(
      // Scaffold proporciona la estructura visual básica (app bar, body, etc.)
      home: Scaffold(
        // Barra superior de la aplicación con un título
        appBar: AppBar(title: Text("Ejemplo Flutter")),
        // El cuerpo de la pantalla
        body: Center(
          // El widget Text muestra un mensaje en pantalla
          child: Text(
            "¡Hola Mundo!", // Texto que se renderiza
            style: TextStyle(
              fontSize: 24,   // Tamaño de letra
              color: Colors.blue, // Color del texto
            ),
          ),
        ),
      ),
    );
  }
}
