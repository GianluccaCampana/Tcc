package com.example.blacaleletrica;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public abstract class ConexaoBD {
    private  static FirebaseAuth firebaseAuth ;
    private  static  FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;


    private ConexaoBD(){

    }


    public static FirebaseAuth getFirebaseAuth(){

        if(firebaseAuth == null){ // nenhuma conta esteja cadastrada
            inciarFirebase();
        }
        return  firebaseAuth; // caso ja tenha cadastro, retorna o usuário cadastrado

    }

    private static void inciarFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();// regatando dados e verificando se tem algum usuário cadastrado
                if(user != null){
                    firebaseUser = user;
                }
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener); // adc usuário ao banco
    }
    public static FirebaseUser getFirebaseUser(){
        // usuário logado
        return firebaseUser;
    }

    public static void saida(){
        // fazer logout
       firebaseAuth.getInstance().signOut();
    }


}
