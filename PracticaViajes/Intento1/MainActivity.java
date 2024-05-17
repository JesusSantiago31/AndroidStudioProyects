package com.tesji.viajes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txEmail;
    private TextInputEditText txPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txEmail = findViewById(R.id.txtUser);
        txPassword = findViewById(R.id.txtPassword);
        btLogin = findViewById(R.id.btnIngresar);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (txEmail.getText().toString().trim().isEmpty() ) {
                        txEmail.setText(null);
                        txEmail.setError("Rellene el campo");
                    } else if (txPassword.getText().toString().trim().isEmpty()) {
                        txPassword.setText(null);
                        txPassword.setError("Rellene el campo");
                    } else {
                        if (txEmail.getText().toString().equals("example@tesji.edu") && txPassword.getText().toString().equals("1234")) {
                            Toast.makeText(MainActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                            Intent api = new Intent(MainActivity.this, api.class);
                            startActivity(api);
                        } else {
                            Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                            txPassword.setText(null);
                            txEmail.setText(null);
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error Fatal", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}