package com.example.parcial2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView Saludo;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button btnConvertir;
    private TextView txtResultado1;
    private TextView txtResultado2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        String nombre = getIntent().getStringExtra("nombre");
        Saludo = findViewById(R.id.txtSa);
        Saludo.setText("Hola, tu nombre es: " + nombre);

        spinner1 = findViewById(R.id.spinner2);
        spinner2 = findViewById(R.id.spinner3);

        btnConvertir = findViewById(R.id.btn1);
        txtResultado1 = findViewById(R.id.txt1);
        txtResultado2 = findViewById(R.id.text2);

        String op = getIntent().getStringExtra("opcionSeleccionada");

        if (op.equals("Logitud"))
            Longitud();
        else if (op.equals("Transmicion de datos"))
            TransmisionDatos();
        else
            TamanoDatos();

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarConversiones();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void realizarConversiones() {
        String unidadOrigen = spinner1.getSelectedItem().toString();
        String unidadDestino = spinner2.getSelectedItem().toString();

        double valorAConvertir = Double.parseDouble(txtResultado1.getText().toString());
        double resultado2 = 0.0;

        if (unidadOrigen.equals("Metros") && unidadDestino.equals("Kilómetros")) {
            resultado2 = valorAConvertir / 1000;
        } else if (unidadOrigen.equals("Kilómetros") && unidadDestino.equals("Metros")) {
            resultado2 = valorAConvertir * 1000;
        } else if (unidadOrigen.equals("Centímetros") && unidadDestino.equals("Metros")) {
            resultado2 = valorAConvertir / 100;
        } else if (unidadOrigen.equals("Metros") && unidadDestino.equals("Centímetros")) {
            resultado2 = valorAConvertir * 100;
        } else if (unidadOrigen.equals("Centímetros") && unidadDestino.equals("Kilómetros")) {
            resultado2 = valorAConvertir * 0.00001;
        } else if (unidadOrigen.equals("Kilómetros") && unidadDestino.equals("Centímetros")) {
            resultado2 = valorAConvertir * 100000;
        }

        if (unidadOrigen.equals("Gigabit") && unidadDestino.equals("KiloBit")) {
            resultado2 = valorAConvertir * 1000000;
        } else if (unidadOrigen.equals("KiloBit") && unidadDestino.equals("Gigabit")) {
            resultado2 = valorAConvertir / 1000000;
        } else if (unidadOrigen.equals("Gigabit") && unidadDestino.equals("Bit")) {
            resultado2 = valorAConvertir * 1000000000;
        } else if (unidadOrigen.equals("Bit") && unidadDestino.equals("Gigabit")) {
            resultado2 = valorAConvertir / 1000000000;
        } else if (unidadOrigen.equals("KiloBit") && unidadDestino.equals("Bit")) {
            resultado2 = valorAConvertir * 1000;
        } else if (unidadOrigen.equals("Bit") && unidadDestino.equals("KiloBit")) {
            resultado2 = valorAConvertir / 1000;
        }

        if (unidadOrigen.equals("GigaByte") && unidadDestino.equals("Kilobyte")) {
            resultado2 = valorAConvertir * 1000000;
        } else if (unidadOrigen.equals("Kilobyte") && unidadDestino.equals("GigaByte")) {
            resultado2 = valorAConvertir / 1000000;
        } else if (unidadOrigen.equals("GigaByte") && unidadDestino.equals("byte")) {
            resultado2 = valorAConvertir * 1000000000;
        } else if (unidadOrigen.equals("byte") && unidadDestino.equals("GigaByte")) {
            resultado2 = valorAConvertir / 1000000000;
        } else if (unidadOrigen.equals("Kilobyte") && unidadDestino.equals("byte")) {
            resultado2 = valorAConvertir * 1000;
        } else if (unidadOrigen.equals("byte") && unidadDestino.equals("Kilobyte")) {
            resultado2 = valorAConvertir / 1000;
        }

        txtResultado2.setText(String.valueOf(resultado2));
    }

    public void Atras (View sgt){
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }
    public void Cerrar (View vm){
        System.exit(0);
    }

    private void Longitud() {
        String[] elementosSpinner1 = {"Metros", "Kilómetros", "Centímetros"};

        ArrayAdapter<String> adaptadorSpinner1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosSpinner1);
        adaptadorSpinner1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptadorSpinner1);
        spinner2.setAdapter(adaptadorSpinner1);
    }


    private void TransmisionDatos() {
        String[] elementosSpinner1 = {"Gigabit", "KiloBit", "Bit"};

        ArrayAdapter<String> adaptadorSpinner1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosSpinner1);
        adaptadorSpinner1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptadorSpinner1);
        spinner2.setAdapter(adaptadorSpinner1);
    }

    private void TamanoDatos() {
        String[] elementosSpinner1 = {"GigaByte", "Kilobyte", "byte"};

        ArrayAdapter<String> adaptadorSpinner1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementosSpinner1);
        adaptadorSpinner1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptadorSpinner1);
        spinner2.setAdapter(adaptadorSpinner1);
    }
}