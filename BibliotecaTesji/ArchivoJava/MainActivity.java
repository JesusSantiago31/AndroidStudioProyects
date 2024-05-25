package com.tesji.bibliotecatesji;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //1.-Declaral los views a manipular
    private TextInputEditText txNumero;
    private TextInputEditText txNombre;
    private TextInputEditText txAutor;
    private TextInputEditText txEdicion;
    private TextInputEditText txAnio;
    private Button btregistrar;
    private Button btNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.-Referenciar los views declarados con el id
        //definido en el xml (vista)
        txNumero = findViewById(R.id.txtNumero);
        txNombre = findViewById(R.id.txtNombre);
        txAutor = findViewById(R.id.txtAutor);
        txEdicion = findViewById(R.id.txtEdicion);
        txAnio = findViewById(R.id.txtAnio);
        btregistrar = findViewById(R.id.btnregistrar);
        btNuevo = findViewById(R.id.btnnuevo);

        //3.-Generar el evento clic para el boton
        btregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre= txNombre.getText().toString();
                String autor= txAutor.getText().toString();
                String edicion= txEdicion.getText().toString();
                Toast.makeText(getApplicationContext(),"El nombre del libro es " + nombre + "de l autor: "+ autor +" y edicion: "+ edicion, Toast.LENGTH_LONG).show();

            }
        });

        btNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txNombre.setText(null);
                txAutor.setText(null);
                txEdicion.setText(null);
                txAnio.setText(null);
                txNumero.setText(null);
            }
        });
    }
}