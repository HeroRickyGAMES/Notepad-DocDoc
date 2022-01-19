package com.herorickystudios.notepaddocdoc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email, senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.textEmailLogin);
        senha = findViewById(R.id.textsenhalogin);

    }

    public void btnlogin(View v){
        String emaild = email.getText().toString();
        String senhad = senha.getText().toString();


        if( emaild.isEmpty() || senhad.isEmpty() ){
            Snackbar snackbar = Snackbar.make(v, "Preencha todos os campos!",Snackbar.LENGTH_LONG);
            snackbar.show();
        }else{
           autenticarusuario(v);
        }
    }
    public void autenticarusuario(View view){
        String emaila = email.getText().toString();
        String senhaa = senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(emaila,senhaa).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AbrirTelaInicial();
                        }
                    }, 3000);
                }else{
                    String erro;
                    try {
                        throw task.getException();
                    }catch (Exception e){
                        erro = "Erro ao logar!";
                        Snackbar snackbar = Snackbar.make(view, erro,Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            }
        });
    }

    public void AbrirTelaInicial(){

        Intent intent = new Intent(this, NotasActivity.class);
        startActivity(intent);

    }
}