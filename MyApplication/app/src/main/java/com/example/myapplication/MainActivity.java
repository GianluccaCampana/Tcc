package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declarando as variáveis e conectando elas com o XML
  private  TextView nome = (TextView) findViewById(R.id.textViewNome);
  private  TextView senha = (TextView) findViewById(R.id.textViewSenha);
  private  Button btLogin = (Button) findViewById(R.id.login);
  private  Button btCadastro = (Button) findViewById(R.id.cadastro);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // Entrando em outra activity
                Intent intent =  new Intent(MainActivity.this, TelaPrincipal.class);
                                            // primeiro a activity que está e segundo para qual acticity vai
                startActivity(intent);


            }
        });

        };
    }



