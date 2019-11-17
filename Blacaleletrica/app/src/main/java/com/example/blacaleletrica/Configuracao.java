package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Configuracao extends AppCompatActivity {

    private Button upload, logout , del;
    private FirebaseAuth userLlogout  = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
        upload = (Button)findViewById(R.id.btnUpload);
        logout = (Button)findViewById(R.id.btnlogout);
        del = (Button)findViewById(R.id.btnDelete);


        eventoBotoes();


    }
////////////////// acessar a NBR ////////////////////////////////////
    private void eventoBotoes() {
        upload.setOnClickListener(new View.OnClickListener() {
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

    }
    ////////////// Método toast


    private void msg(String msg) {
        Toast.makeText(Configuracao.this,msg,Toast.LENGTH_SHORT).show();
    }
}
