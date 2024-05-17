package com.tesji.viajes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tesji.viajes.Interface.CountryApiService;
import com.tesji.viajes.Model.Country;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api extends AppCompatActivity {

    private Button btInfo;
    private EditText txNameC;
    private TextView countryTextView;
    private TextView capitalTextView;
    private TextView languageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        btInfo = findViewById(R.id.btnObtenerInfo);
        txNameC = findViewById(R.id.etCountry);
        countryTextView = findViewById(R.id.tvCountry);
        capitalTextView = findViewById(R.id.tvCapital);
        languageTextView = findViewById(R.id.tvLanguage);

        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryName = "Mexico";

                // Verificar la conectividad de red antes de realizar la llamada a la API
                if (isNetworkAvailable()) {
                    // Creación de la instancia de la clase AsyncTask
                    new CountryAsyncTask(api.this, countryTextView, languageTextView, capitalTextView, countryName).execute(countryName);
                } else {
                    Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para verificar la conectividad de red
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    // Clase AsyncTask estática para realizar la solicitud a la API
    private static class CountryAsyncTask extends AsyncTask<String, Void, List<Country>> {
        private TextView countryTextView;
        private TextView languageTextView;
        private  TextView capitalTextView;
        private Context context;
        private String countryName;
        // Constructor que recibe countryTextView como parámetro


        public CountryAsyncTask(Context context, TextView countryTextView, TextView languageTextView, TextView capitalTextView,  String countryName) {
            this.countryTextView = countryTextView;
            this.languageTextView = languageTextView;
            this.capitalTextView = capitalTextView;
            this.context = context;
            this.countryName = countryName;
        }

        @Override
        protected List<Country> doInBackground(String... strings) {
            try {
                // Crear instancia de Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://restcountries.com/v3.1/name/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                // Crear instancia de CountryApiService
                CountryApiService apiService = retrofit.create(CountryApiService.class);

                // Hacer la llamada a la API con el nombre del país
                Call<List<Country>> call = apiService.getCountryByName(countryName);

                // Ejecutar la llamada de manera asíncrona
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
                            // Manejar errores de respuesta HTTP
                            Log.e("API Response", "Error en la respuesta de la API: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {
                        // Manejar errores de red
                        Log.e("API Error", "Error de red: " + t.getMessage());
                    }
                });
            } catch (Exception e) {
                // Manejar errores de red
                Log.e("API Error", "Error de red: " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Country> countries) {
            super.onPostExecute(countries);
            if (countries == null || countries.isEmpty()) {
                // La lista de países está vacía o la llamada falló
                Toast.makeText(context, "No se encontraron datos para el país especificado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}