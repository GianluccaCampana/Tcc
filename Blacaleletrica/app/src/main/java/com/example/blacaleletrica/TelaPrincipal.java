package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    private Button tomadas;
    private Button luminaria;
    private Button configuracao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        tomadas = (Button) findViewById(R.id.buttonCalTom);
        luminaria = (Button) findViewById(R.id.buttonCalLum);
        configuracao = (Button) findViewById(R.id.buttonConfig);

        tomadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tom = new Intent(TelaPrincipal.this, Tomadas.class);
                startActivity(tom);
            }
        });


        luminaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lum = new Intent(TelaPrincipal.this, Luminaria.class);
                startActivity(lum);
            }
        });

        configuracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config = new Intent(TelaPrincipal.this, Configuracao.class);
                startActivity(config);
            }
        });
    }
}
