// Importamos el paquete principal de Flutter que nos da acceso a widgets
// y a todo lo que necesitamos para crear interfaces gráficas.
import 'package:flutter/material.dart';

// La función principal de todo programa en Dart/Flutter.
// Aquí usamos "runApp" para ejecutar la aplicación.
// MyApp será la clase que definimos más abajo.
void main() => runApp(MyApp());

// Creamos una clase que representa la aplicación.
// Como queremos que el contador cambie cuando hagamos clic,
// usamos "StatefulWidget" (widget con estado).
class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

// Esta clase guarda el "estado" de la app, en este caso el valor del contador.
// Aquí es donde se define cómo se ve la interfaz y cómo reacciona.
class _MyAppState extends State<MyApp> {
  // Variable que guarda el valor del contador, inicia en 0.
  int contador = 0;

  // Función que se llama cuando se presiona el botón.
  // "setState" es muy importante, le dice a Flutter que algo cambió
  // y que debe redibujar la interfaz con el nuevo valor.
  void aumentar() {
    setState(() { // Actualizar el la UI con el nuevo valor
      contador++;
    });
  }

  // Método que construye la interfaz gráfica de la app.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold( // Estructura básica de pantalla en Flutter.
        appBar: AppBar(title: Text("Contador Flutter")), // Barra superior con título.

        body: Center( // Centra el contenido en la pantalla.
          child: Text(
            "Contador: $contador", // Mostramos el número actual del contador.
            style: TextStyle(fontSize: 30), // Ajustamos el tamaño del texto.
          ),
        ),

        // Botón flotante (el que aparece abajo a la derecha con un ícono de "+").
        floatingActionButton: FloatingActionButton(
          onPressed: aumentar, // Acción: cuando se presiona, llama a la función aumentar().
          child: Icon(Icons.add), // Icono de suma (+).
        ),
      ),
    );
  }
}
