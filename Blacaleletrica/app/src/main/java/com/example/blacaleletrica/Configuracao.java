package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Configuracao extends AppCompatActivity {

    private Button nbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        nbr = (Button)findViewById(R.id.buttonNbr);

        nbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nbr5410 = new Intent(Configuracao.this, Nbr.class);
                startActivity(nbr5410);
            }
        });
    }
}
