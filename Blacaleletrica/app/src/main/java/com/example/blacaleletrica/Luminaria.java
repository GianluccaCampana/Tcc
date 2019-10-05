package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import static com.example.blacaleletrica.R.layout.activity_luminaria;

public class Luminaria extends AppCompatActivity {

   private EditText lar,comp,resul;
   private Button calLum;
   private RadioGroup ambienteL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_luminaria);

         lar=(EditText)findViewById(R.id.editTextComprimentoLum);
         comp=(EditText) findViewById(R.id.editTextComprimentoLum);
         resul=(EditText)findViewById(R.id.editTextResulLum);
         calLum=(Button)findViewById(R.id.buttonCalcularLum);
         ambienteL = (RadioGroup)findViewById(R.id.Ambientes);

        calLum.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int ambL = ambienteL.getCheckedRadioButtonId();

                 double numb1=Double.parseDouble(lar.getText().toString());
                 double numb2=Double.parseDouble(comp.getText().toString());


                 if(ambL == R.id.radioButtonSala){
                     double calc = numb1 * numb2 ;
                     double lum = 150*calc ;

                     resul.setText(String.valueOf(lum));
                 }else if(ambL == R.id.radioButtonCozinha){
                     double calc = (numb1 * numb2) * 300;
                     resul.setText(String.valueOf(calc));
                 }else if(ambL == R.id.radioButtonQuarto){
                     double calc = (numb1 * numb2) * 150;
                     resul.setText(String.valueOf(calc));
                 }else if(ambL == R.id.radioButtonBanheiro){
                     double calc = (numb1 * numb2) * 150;
                     resul.setText(String.valueOf(calc));
                 }else if(ambL == R.id.radioButtonGeral){
                     double calc = (numb1 * numb2) * 100;
                     resul.setText(String.valueOf(calc));
                 }

             }
         });

    }
}
