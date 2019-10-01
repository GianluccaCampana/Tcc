package com.example.blacaleletrica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Tomadas extends AppCompatActivity {

    EditText comp, lar, resul;
    Button cal;
    RadioGroup grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomadas);

        comp =(EditText)findViewById(R.id.editTextComprimento);
        lar = (EditText)findViewById(R.id.editTextLargura);
        resul=(EditText)findViewById(R.id.editTextResul);
        cal=(Button)findViewById(R.id.buttonResulTom);
        grupo=(RadioGroup)findViewById(R.id.opcoes);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int op = grupo.getCheckedRadioButtonId();

                double numb1 = Double.parseDouble(comp.getText().toString());
                double numb2= Double.parseDouble(lar.getText().toString());


                if(op == R.id.radioButton1) {
                    double total = ((numb1 * 2) + (numb2 * 2)) / 3.5;

                    resul.setText(String.valueOf(total));
                }else if(op == R.id.radioButton2){
                    double total = ((numb1 * 2) + (numb2 * 2)) / 5;

                    resul.setText(String.valueOf(total));
                }else if(op == R.id.radioButton3){
                    double total =1;
                    resul.setText(String.valueOf(total));
                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(Tomadas.this);
                    alert.setTitle("Nenhum comodo selecionado");
                    alert.setNeutralButton("ok", null);
                }



            }
        });



    }
}
