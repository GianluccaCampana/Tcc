package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    private Button btTom = (Button) findViewById(R.id.buttonTomada);
    private Button btLum = (Button) findViewById(R.id.buttonLuminaria);
    private Button btConfig = (Button) findViewById(R.id.buttonConfig);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btTom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tom = new Intent(TelaPrincipal.this, TomadasCal.class);
                startActivity(tom);

            }
        });


    }

}
