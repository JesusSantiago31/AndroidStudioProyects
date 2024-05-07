package com.tesji.practicaspinner;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tesji.practicaspinner.model.CarrerasModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
private Spinner spCliente;
private Spinner spPago;
private TextInputEditText tilMonto;
private TextView tvImprimir;
String[] opCliente = {"** Tipo de Cliente **"," Cliente General"," Cliente Afiliado"};
String [] opPago = {"** Tipo de Pago **", " Credito"," Contado"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spCliente = findViewById(R.id.sppinnerCliente);
        spPago = findViewById((R.id.sppinnerPago));
        tilMonto = findViewById(R.id.txtMonto);
        tvImprimir = findViewById(R.id.textViewImprimir);

        ArrayAdapter<String> adapCliente = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,opCliente);
        spCliente.setAdapter(adapCliente);
        ArrayAdapter<String> adapPago = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,opPago);
        spPago.setAdapter(adapPago);

        spPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CarrerasModel clienteC = new CarrerasModel();
                clienteC.setCliente(spCliente.getSelectedItemPosition());
                clienteC.setPago(spPago.getSelectedItemPosition());
                clienteC.setMonto(Integer.parseInt(Objects.requireNonNull(tilMonto.getText()).toString()));
                tvImprimir.setText(clienteC.mostrarInfo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CarrerasModel clienteC = new CarrerasModel();
                clienteC.setCliente(spCliente.getSelectedItemPosition());
                clienteC.setPago(spPago.getSelectedItemPosition());
                clienteC.setMonto(Integer.parseInt(Objects.requireNonNull(tilMonto.getText()).toString()));
                tvImprimir.setText(clienteC.mostrarInfo());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}