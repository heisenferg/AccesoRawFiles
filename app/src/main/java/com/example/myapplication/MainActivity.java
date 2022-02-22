package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
Button mostrar;
TextView recurso;
String linea, texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = findViewById(R.id.buttonMostrar);
        recurso = findViewById(R.id.textViewMostrar);

        Resources r = getResources();
        InputStream in = r.openRawResource(R.raw.prueba);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto = new String();
                try{
                    while ((linea=bf.readLine()) !=null){
                        texto += linea;
                    }
                }catch (IOException e){
                    Log.d("Excepción: ", "Error");
                }

                recurso.setText(texto);
            }
        });

    }


}