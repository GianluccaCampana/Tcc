package com.example.blacaleletrica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailLogin, senhaLogin;
    private Button btnLogin, btnCadastro, btnEsqueceuSenha;
    private FirebaseAuth aut;
    private  FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLogin=(EditText)findViewById(R.id.emailLogin);
        senhaLogin=(EditText)findViewById(R.id.senhaLogin);
        btnCadastro = (Button)findViewById(R.id.btnCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnEsqueceuSenha=(Button)findViewById(R.id.resetSenha);

           acessoTelas();


    }



    private void acessoTelas() {

        ////////////// Effetuar login ////////////////////////////////////
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailLogin.getText().toString().trim().equals("") || senhaLogin.getText().toString().equals("")){
                    msg("Necessário o preencimentos dos campos em branco");
                }else {

                    String email = emailLogin.getText().toString().trim();
                    String senha = senhaLogin.getText().toString().trim();


                    login(email, senha);
                }

            }


        });


        //////////Ir para tela de cadastro //////////////////////////////

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cad = new Intent(MainActivity.this, Cadastro.class);
                startActivity(cad);

            }
        });


        /////////////////// ir para tela esqueceu senha //////////////////////////////
        btnEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EsqueceuSenha.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        aut = ConexaoBD.getFirebaseAuth();
        //user = ConexaoBD.getFirebaseUser();
        verificaUser(); // método para manter logado após o fechamento

    }


    private void verificaUser() {
        // Lógica confore documentação do firebase
        FirebaseUser user = aut.getInstance().getCurrentUser();

        if(user != null){
            Intent i = new Intent(MainActivity.this, TelaPrincipal.class);
            startActivity(i);
        }else{
            msg("necessario cadastro ou login");

        }
    }

    /////////////////////////// MÉTODO LOGIN /////////////////////
    private void login(String email, String senha) {

        aut.signInWithEmailAndPassword(email, senha)


                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                                msg("Login com sucesso");
                                Intent intent = new Intent(MainActivity.this, TelaPrincipal.class);
                                startActivity(intent);
                                finish();

                        }else{
                            msg("Login Incorreto");
                        }
                    }


                });
    }
//////////////////////////////// MENSAGEM  /////////////////////////////////
    private void msg(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }


}
