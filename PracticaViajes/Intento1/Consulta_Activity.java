package com.tesji.viajes;

import android.content.Intent;
import android.net.http.UrlRequest;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tesji.viajes.Interface.CountryApiService;
import com.tesji.viajes.Model.Country;
import com.tesji.viajes.Model.ModeloRetorno;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class  Consulta_Activity extends AppCompatActivity {

    public Button btVolver;
    public EditText txNameC;
    public TextView countryTextView;
    public TextView capitalTextView;
    public TextView languageTextView;
    public String respuesta = "", imagen = "";
    public ModeloRetorno world = new ModeloRetorno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        btVolver = findViewById(R.id.btn_volver);
        countryTextView = findViewById(R.id.tvCountry);
        capitalTextView  = findViewById(R.id.tvCapital);
        languageTextView = findViewById(R.id.tvLanguage);

        btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Nombre del país deseado
                String countryName = "Mexico";

                // Crear instancia de Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://restcountries.com/v3.1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Crear instancia de CountryApiService
                CountryApiService apiService = retrofit.create(CountryApiService.class);

                // Hacer la llamada a la API con el nombre del país
                Call<List<Country>> call = apiService.getCountryByName(countryName);

                // Procesar la respuesta de la API
                call.enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        if (response.isSuccessful()) {
                            List<Country> countries = response.body();
                            if (countries != null && !countries.isEmpty()) {
                                Country country = countries.get(0); // Obtener el primer país de la lista
                                // Mostrar la información del país en los TextViews
                                countryTextView.setText("Nombre del país: " + country.getName().getCommon());
                                capitalTextView.setText("Capital: " + country.getCapital());
                                languageTextView.setText("Idioma: " + country.getLanguages().get("spa")); // Suponiendo que quieres obtener el nombre del idioma en español
                            }
                        } else {
                            // Manejar errores de respuesta
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {
                        // Manejar errores de red
                    }
                });
            }
        });

    }
}

