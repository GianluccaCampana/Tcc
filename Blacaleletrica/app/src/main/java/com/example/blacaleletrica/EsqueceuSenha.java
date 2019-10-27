package com.example.blacaleletrica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class EsqueceuSenha extends AppCompatActivity {

   private Button btnVoltar, btnReset;
   private EditText emailReset;
   private FirebaseAuth  aut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);
        btnVoltar=(Button)findViewById(R.id.btnTelaLoginResetSenha);
        btnReset=(Button)findViewById(R.id.btnEnviarResetSenha);
        emailReset=(EditText) findViewById(R.id.emailResetSenha);

        funcaoBotoes();
    }

    private void funcaoBotoes() {
        ///////////////Voltar para tela login ///////////////////////////
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EsqueceuSenha.this, MainActivity.class);
                startActivity(i);
            }
        });

        //////Alterar senha ////////////////
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailReset.getText().toString().equals("")){
                    mensagem("Preencha o campo e-mail");
                }else {
                    String email = emailReset.getText().toString().trim();
                    resetSenha(email);
                }
            }
        });

    }

    private void resetSenha(String email) {
        aut.sendPasswordResetEmail(email)

                .addOnCompleteListener(EsqueceuSenha.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                        mensagem("Verificar e-mail");
                        Intent i = new Intent(EsqueceuSenha.this, MainActivity.class);
                        startActivity(i);
                        }else {
                            mensagem("E-mail não encontrado");
                        }
                    }
                });
    }

    private void mensagem(String msg) {
        Toast.makeText(EsqueceuSenha.this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        aut = ConexaoBD.getFirebaseAuth();
    }
}
