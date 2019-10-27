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
import com.google.firebase.auth.FirebaseUser;

public class DeletarConta extends AppCompatActivity {
    private Button del, vol;
    private EditText emailDel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_conta);

        del = (Button)findViewById(R.id.btndeleteConta);
        emailDel= (EditText)findViewById(R.id.emailDelete);

        deletar();

    }

    private void deletar() {

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailDel.getText().toString().trim();
                del(email);
            }
        });
    }

    private void del(String email) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    mensagem("Deletada com sucesso");
                    Intent i = new Intent(DeletarConta.this, MainActivity.class);
                    startActivity(i);
                }else{
                    mensagem("Conta não encontrada");
                }
            }
        });



    }

    private void mensagem(String msg) {
        Toast.makeText(DeletarConta.this, msg,Toast.LENGTH_SHORT).show();

    }


}
