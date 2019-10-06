package com.example.blacaleletrica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tomadas extends AppCompatActivity {

    // Delclaração de viriáveis
    EditText comp, lar, resul;
    Button cal;
    RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomadas);

        // Conectando elas com XML
        comp =(EditText)findViewById(R.id.editTextComprimentoTom);
        lar = (EditText)findViewById(R.id.editTextLarguraTom);
        resul=(EditText)findViewById(R.id.editTextResulTom);
        cal=(Button)findViewById(R.id.buttonResulTom);
        grupo=(RadioGroup)findViewById(R.id.opcoes);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int op = grupo.getCheckedRadioButtonId(); //conectando os radios


                // declaração de variáveis
                double numb1 = 0;

                double numb2= 0;



                // Verificando a id dos radios, para ai sim efetuar os cálculos
                 if(numb1 == 0 || numb2 ==0){

                    // Caso falte algum valor em largura ou comprimento irá aparecer mensagem de alerta
                    Context alerta = getApplicationContext();
                    Toast toast = Toast.makeText(alerta,"Necessario que largura ou compromento esteja preechido", Toast.LENGTH_SHORT);
                    toast.show();
                }else if(op == R.id.radioButton1) {

                    //convertendo valores digitados em double
                    numb1 = Double.parseDouble(comp.getText().toString());
                    numb2 = Double.parseDouble(lar.getText().toString());

                    double total = ((numb1 * 2) + (numb2 * 2)) / 3.5;

                    // mostrar o resultado o resultado no editText resultado
                    // Math.round arredonda o resulta pra cima
                    resul.setText(String.valueOf(Math.round(total)));
                }else if(op == R.id.radioButton2){
                    //convertendo valores digitados em double
                    numb1 = Double.parseDouble(comp.getText().toString());
                    numb2 = Double.parseDouble(lar.getText().toString());


                    double total = ((numb1 * 2) + (numb2 * 2)) / 5;

                    // mostrar o resultado o resultado no editText resultado
                    // Math.round arredonda o resulta pra cima
                    resul.setText(String.valueOf(Math.round(total)));
                }else if(op == R.id.radioButton3){
                    //convertendo valores digitados em double
                    numb1 = Double.parseDouble(comp.getText().toString());
                    numb2 = Double.parseDouble(lar.getText().toString());


                    double total =1;

                    // mostrar o resultado o resultado no editText resultado
                    // Math.round arredonda o resulta pra cima
                    resul.setText(String.valueOf(Math.round(total)));
                }else{

                    // caso nenhum cômodo seja selecionado aparecerá uma mensagem de alerta com toast
                    Context alerta = getApplicationContext();
                    Toast toast = Toast.makeText(alerta, "Nunhum Cômodo selecionado", Toast.LENGTH_LONG);
                    toast.show();
                }



            }
        });



    }
}
