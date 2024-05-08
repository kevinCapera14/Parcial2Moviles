package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Spinner();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Spinner(){
        Spinner spinner = findViewById(R.id.spinner);
        String[] elementos = {"Logitud", "Transmicion de datos", "Tamaño de datos"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
    }

    public void Next (View sgt){
        Name = findViewById(R.id.nametext);
        String nombre = Name.getText().toString();
        spinner = findViewById(R.id.spinner);
        String opcionSeleccionada = spinner.getSelectedItem().toString();

        Intent siguiente = new Intent(this, MainActivity2.class);
        siguiente.putExtra("nombre", nombre);
        siguiente.putExtra("opcionSeleccionada", opcionSeleccionada);
        startActivity(siguiente);
    }

    public void Cerrar (View vm){
        System.exit(0);
    }
}