package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.blacaleletrica.R.layout.activity_luminaria;

public class Luminaria extends AppCompatActivity {

   private EditText lar,comp,resul;
   private Button calLum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_luminaria);

         lar=(EditText)findViewById(R.id.editTextComprimentoLum);
         comp=(EditText) findViewById(R.id.editTextComprimentoLum);
         resul=(EditText)findViewById(R.id.editTextResulLum);
         calLum=(Button)findViewById(R.id.buttonCalcularLum);

        calLum.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 double numb1=Double.parseDouble(lar.getText().toString());
                 double numb2=Double.parseDouble(comp.getText().toString());
                 double metroQuadrado;
                 metroQuadrado = numb1 + numb2;
                 double pot = 100;

                 for (int i = 0; metroQuadrado-6>=4; i++){

                     metroQuadrado-=4;
                     pot +=60;
                 }
                 resul.setText(String.valueOf(pot));

             }
         });

    }
}
