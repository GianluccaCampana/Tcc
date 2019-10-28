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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {


    private EditText emailCadastro;
    private EditText senhaCadastro;
    private Button buttonCadastro;
    private  Button voltarLogin;
    private FirebaseAuth cadUser = FirebaseAuth.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        voltarLogin = (Button)findViewById(R.id.btnVoltar);
        buttonCadastro = (Button)findViewById(R.id.btnCadastro);
        emailCadastro = (EditText)findViewById(R.id.emailCadastro);
        senhaCadastro = (EditText)findViewById(R.id.senhaCadastro);

        eventosBotao();





    }

    private void eventosBotao() {
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(emailCadastro.getText().toString().trim().equals("")|| senhaCadastro.getText().toString().equals("")){
                    mensagem("Necessário o preenchimentos de todos os campos");
                }else {

                    // ligando as variáveis com os editText
                    String email = emailCadastro.getText().toString().trim();
                    String senha = senhaCadastro.getText().toString().trim();

                    criarUsuario(email, senha);
                }
            }

            private void criarUsuario( String email, String senha) {
                cadUser.createUserWithEmailAndPassword(email, senha)

                        //saber se o cadastro foi concluído com sucesso pelo task
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //cadastro com sucesso irá aparecer uma e mensagem e será jodado para tela principal
                                    mensagem("Cadastro com sucesso");
                                    Intent intent = new Intent(Cadastro.this, TelaPrincipal.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    mensagem("Erro de cadastro");
                                }
                            }
                        });
            }
        });

        voltarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(Cadastro.this, MainActivity.class);
                startActivity(voltar);
            }
        });
    }



    private void mensagem(String msg){
        Toast.makeText(Cadastro.this,msg,Toast.LENGTH_SHORT).show();
    }
}
