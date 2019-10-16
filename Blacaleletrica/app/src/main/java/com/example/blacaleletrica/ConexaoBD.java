package com.example.blacaleletrica;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.lang.reflect.Field;

public abstract class ConexaoBD {
    private  static FirebaseAuth firebaseAuth ;
    private  static  FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser usuario;


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
                FirebaseUser user = firebaseAuth.getCurrentUser();// regatando dados e verificando se tem algum usuário cadastrado
                if(user != null){
                    usuario = user;
                }
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener); // adc usuário ao banco
    }
    public static FirebaseUser getFirebaseUser(){
        // usuário logado
        return  usuario;
    }

    public static void saida(){
        // fazer logout
       firebaseAuth.signOut();
    }

    public static void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        ConexaoBD.firebaseAuth = firebaseAuth;
    }

    public static FirebaseAuth.AuthStateListener getAuthStateListener() {
        return authStateListener;
    }

    public static void setAuthStateListener(FirebaseAuth.AuthStateListener authStateListener) {
        ConexaoBD.authStateListener = authStateListener;
    }

    public static FirebaseUser getUsuario() {
        return usuario;
    }

    public static void setUsuario(FirebaseUser usuario) {
        ConexaoBD.usuario = usuario;
    }
}
