package com.example.blacaleletrica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailLogin, senhaLogin;
    private Button btnLogin, btnCadastro;
    private TextView  textEsqueceuSenha;
    private FirebaseAuth userLogin = FirebaseAuth.getInstance();
    private  FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLogin=(EditText)findViewById(R.id.emailLogin);
        senhaLogin=(EditText)findViewById(R.id.senhaLogin);
        btnCadastro = (Button)findViewById(R.id.btnCadastrar);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textEsqueceuSenha =(TextView) findViewById(R.id.resetSenha);

           acessoTelas();

           verificaUser(); // Método para manter usuário logado


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
        textEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, EsqueceuSenha.class);
                startActivity(i);
            }
        });

    }

    ///// Manter logado
private void verificaUser() {
        // Lógica confore documentação do firebase
        FirebaseUser user = userLogin.getInstance().getCurrentUser();

        if(user != null){
            Intent i = new Intent(MainActivity.this, TelaPrincipal.class);
            startActivity(i);
        }else{
            msg("necessario cadastro ou login");

        }
    }

    /////////////////////////// MÉTODO LOGIN /////////////////////
    private void login(String email, String senha) {

        userLogin.signInWithEmailAndPassword(email, senha)


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
