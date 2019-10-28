package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

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
   private EditText larLum, compLum,resul;
   private Button calLum;
   private RadioGroup ambienteL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_luminaria);

        // Ligando variáveis com xml
         larLum =(EditText)findViewById(R.id.editTextLargLum);
         compLum =(EditText) findViewById(R.id.editTextComprimentoLum);
         resul=(EditText)findViewById(R.id.editTextResulLum);
         calLum=(Button)findViewById(R.id.buttonCalcularLum);
         ambienteL = (RadioGroup)findViewById(R.id.Ambientes);



         calculo();



    }

    private void calculo() {
        calLum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ambL = ambienteL.getCheckedRadioButtonId();// ligandos com os radios

                double num1Lum =0;
                double num2Lum =0;

                if(ambL == R.id.radioButtonSala){
                    if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                        Context alerta= getApplicationContext();
                        Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        num1Lum = Double.parseDouble(compLum.getText().toString());
                        num2Lum = Double.parseDouble(larLum.getText().toString());
                        //convertendo valores digitados para double

                        double calc = (num1Lum * num2Lum) * 150;
                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(calc)));
                    }
                }else if(ambL == R.id.radioButtonCozinha){

                    if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                        Context alerta= getApplicationContext();
                        Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {
                        num1Lum = Double.parseDouble(compLum.getText().toString());
                        num2Lum = Double.parseDouble(larLum.getText().toString());
                        //convertendo valores digitados para double

                        double calc = (num1Lum * num2Lum) * 300;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(calc)));
                    }
                }else if(ambL == R.id.radioButtonQuarto){

                    if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                        Context alerta= getApplicationContext();
                        Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {
                        num1Lum = Double.parseDouble(compLum.getText().toString());
                        num2Lum = Double.parseDouble(larLum.getText().toString());
                        //convertendo valores digitados para double
                        double calc = (num1Lum * num2Lum) * 150;


                    }
                }else if(ambL == R.id.radioButtonBanheiro){
                    if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                        Context alerta= getApplicationContext();
                        Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {
                        num1Lum = Double.parseDouble(compLum.getText().toString());
                        num2Lum = Double.parseDouble(larLum.getText().toString());
                        //convertendo valores digitados para double


                        double calc = (num1Lum * num2Lum) * 150;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(calc)));
                    }
                }else if(ambL == R.id.radioButtonGeral){
                    if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                        Context alerta= getApplicationContext();
                        Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        num1Lum = Double.parseDouble(compLum.getText().toString());
                        num2Lum = Double.parseDouble(larLum.getText().toString());
                        //convertendo valores digitados para double

                        double calc = (num1Lum * num2Lum) * 100;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(calc)));
                    }
                }else if(larLum.getText().toString().trim().equals("")|| compLum.getText().toString().trim().equals("")){
                    Context alerta= getApplicationContext();
                    Toast toast = Toast.makeText(alerta,"necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                    toast.show();
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
