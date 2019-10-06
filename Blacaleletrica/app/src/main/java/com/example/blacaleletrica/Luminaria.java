package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.blacaleletrica.R.layout.activity_luminaria;

public class Luminaria extends AppCompatActivity {


    // declarando variáveis
   private EditText lar,comp,resul;
   private Button calLum;
   private RadioGroup ambienteL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_luminaria);

        // Ligando variáveis com xml
         lar=(EditText)findViewById(R.id.editTextLargLum);
         comp=(EditText) findViewById(R.id.editTextComprimentoLum);
         resul=(EditText)findViewById(R.id.editTextResulLum);
         calLum=(Button)findViewById(R.id.buttonCalcularLum);
         ambienteL = (RadioGroup)findViewById(R.id.Ambientes);

        calLum.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int ambL = ambienteL.getCheckedRadioButtonId();// ligandos com os radios

                 double numb1= 0;

                 double numb2= 0;


                 if(numb1 == 0 || numb2 == 0){

                     // Caso falte algum valor em largura ou comprimento irá aparecer mensagem de alerta
                     Context alerta = getApplicationContext();
                     Toast toast = Toast.makeText(alerta, "Necessário que seja preechido largura e comprimento", Toast.LENGTH_SHORT);
                     toast.show();

                 }else if(ambL == R.id.radioButtonSala){

                     //convertendo valores digitados para double
                     numb1 =Double.parseDouble(lar.getText().toString());
                     numb2 = Double.parseDouble(comp.getText().toString());
                     double calc = numb1 * numb2 ;
                     double lum = 150*calc ;

                     // mostrar o resultado o resultado no editText resultado
                     // Math.round arredonda o resulta pra cima
                     resul.setText(String.valueOf(Math.round(calc)));
                 }else if(ambL == R.id.radioButtonCozinha){
                     //convertendo valores digitados para double
                     numb1 =Double.parseDouble(lar.getText().toString());
                     numb2 = Double.parseDouble(comp.getText().toString());

                     double calc = (numb1 * numb2) * 300;

                     // mostrar o resultado o resultado no editText resultado
                     // Math.round arredonda o resulta pra cima
                     resul.setText(String.valueOf(Math.round(calc)));
                 }else if(ambL == R.id.radioButtonQuarto){
                     double calc = (numb1 * numb2) * 150;

                     // mostrar o resultado o resultado no editText resultado
                     // Math.round arredonda o resulta pra cima
                     resul.setText(String.valueOf(Math.round(calc)));
                 }else if(ambL == R.id.radioButtonBanheiro){
                     //convertendo valores digitados para double
                     numb1 =Double.parseDouble(lar.getText().toString());
                     numb2 = Double.parseDouble(comp.getText().toString());

                     double calc = (numb1 * numb2) * 150;

                     // mostrar o resultado o resultado no editText resultado
                     // Math.round arredonda o resulta pra cima
                     resul.setText(String.valueOf(Math.round(calc)));
                 }else if(ambL == R.id.radioButtonGeral){
                     //convertendo valores digitados para double
                     numb1 =Double.parseDouble(lar.getText().toString());
                     numb2 = Double.parseDouble(comp.getText().toString());

                     double calc = (numb1 * numb2) * 100;

                     // mostrar o resultado o resultado no editText resultado
                     // Math.round arredonda o resulta pra cima
                     resul.setText(String.valueOf(Math.round(calc)));
                 }else{

                     // caso nenhum cômodo seja selecionado aparecerá uma mensagem de alerta com toast
                     Context alerta= getApplicationContext();
                     Toast toast = Toast.makeText(alerta,"Nenhum cômodo selecionado", Toast.LENGTH_SHORT);
                     toast.show();
                 }

             }
         });

    }
}
