package com.example.blacaleletrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tomadas extends AppCompatActivity {

    // Delclaração de viriáveis
    EditText compTom, larTom, resul;
    Button cal;
    RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomadas);

        // Conectando elas com XML
        compTom =(EditText)findViewById(R.id.editTextComprimentoTom);
        larTom = (EditText)findViewById(R.id.editTextLarguraTom);
        resul=(EditText)findViewById(R.id.editTextResulTom);
        cal=(Button)findViewById(R.id.buttonResulTom);
        grupo=(RadioGroup)findViewById(R.id.opcoes);

        calculo();



    }

    private void calculo() {

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int op = grupo.getCheckedRadioButtonId(); //conectando os radios


                // declaração de variáveis
                double numb1 = 0;

                double numb2= 0;



                // Verificando a id dos radios, para ai sim efetuar os cálculos
                if(op == R.id.radioButton1) {
                    if(compTom.getText().toString().trim().equals("")|| larTom.getText().toString().trim().equals("")){

                        // caso não seja preenchido largura ou comprimento aparecerá uma mensagem de alerta com toast
                        Context alerta = getApplicationContext();
                        Toast toast = Toast.makeText(alerta, "Necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        //convertendo valores digitados em double
                        numb1 = Double.parseDouble(compTom.getText().toString());
                        numb2 = Double.parseDouble(larTom.getText().toString());

                        double total = ((numb1 * 2) + (numb2 * 2)) / 3.5;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(total + "un.")));
                    }
                }else if(op == R.id.radioButton2){
                    if(compTom.getText().toString().trim().equals("")|| larTom.getText().toString().trim().equals("")){

                        // caso não seja preenchido largura ou comprimento aparecerá uma mensagem de alerta com toast
                        Context alerta = getApplicationContext();
                        Toast toast = Toast.makeText(alerta, "Necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        //convertendo valores digitados em double
                        numb1 = Double.parseDouble(compTom.getText().toString());
                        numb2 = Double.parseDouble(larTom.getText().toString());

                        double total = ((numb1 * 2) + (numb2 * 2)) / 5;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(total + "un.")));
                    }
                }else if(op == R.id.radioButton3){
                    if(compTom.getText().toString().trim().equals("")|| larTom.getText().toString().trim().equals("")){

                        // caso não seja preenchido largura ou comprimento aparecerá uma mensagem de alerta com toast
                        Context alerta = getApplicationContext();
                        Toast toast = Toast.makeText(alerta, "Necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {


                        double total = 1;

                        // mostrar o resultado o resultado no editText resultado
                        // Math.round arredonda o resulta pra cima
                        resul.setText(String.valueOf(Math.round(total + "un.")));
                    }
                }else if(compTom.getText().toString().trim().equals("")|| larTom.getText().toString().trim().equals("")){

                    // caso não seja preenchido largura ou comprimento aparecerá uma mensagem de alerta com toast
                    Context alerta = getApplicationContext();
                    Toast toast = Toast.makeText(alerta, "Necessário preenchimento da largura e comprimento", Toast.LENGTH_SHORT);
                    toast.show();
                }

                else{

                    // caso nenhum cômodo seja selecionado aparecerá uma mensagem de alerta com toast
                    Context alerta = getApplicationContext();
                    Toast toast = Toast.makeText(alerta, "Nunhum Cômodo selecionado", Toast.LENGTH_SHORT);
                    toast.show();
                }



            }
        });



    }
}
