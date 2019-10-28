package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Configuracao extends AppCompatActivity {

    private Button nbr, logout , voltar, del;
    private FirebaseAuth userLlogout  = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
        nbr = (Button)findViewById(R.id.btnNbr);
        logout = (Button)findViewById(R.id.btnlogout);
        voltar = (Button)findViewById(R.id.btnvoltar);
        del = (Button)findViewById(R.id.btnDelete);


        eventoBotoes();


    }
////////////////// acessar a NBR ////////////////////////////////////
    private void eventoBotoes() {
        nbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nbr5410 = new Intent(Configuracao.this, Nbr.class);
                startActivity(nbr5410);
            }
        });

        ////////////////////  Fazer logout ///////////////////
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 userLlogout.signOut();
                 msg("Logout com sucesso");
                 Intent i = new Intent(Configuracao.this, MainActivity.class);
                 startActivity(i);

            }


        });

        //////////////////////Tela deletar //////////////////////
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Configuracao.this, DeletarConta.class);
                startActivity(i);
            }
        });

        //////////////////// Voltar tela principal /////////////////////
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vol = new Intent(Configuracao.this, TelaPrincipal.class);
                startActivity(vol);
            }
        });
    }
    ////////////// Método toast


    private void msg(String msg) {
        Toast.makeText(Configuracao.this,msg,Toast.LENGTH_SHORT).show();
    }
}
