package com.herorickystudios.notepaddocdoc;

//Desenvolvido por HeroRickyGames

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editSenha;
    EditText editreSenha;

    public DatabaseReference referencia = FirebaseDatabase.getInstance().getReference("usuarios");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editTextTextPassword);
        editreSenha = findViewById(R.id.editTextTextPassword2);
    }

    public void Cadastro(View v) {

        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        //String resenha = editreSenha.getText().toString();


            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    salvaruser();
                    Snackbar snackbar = Snackbar.make(v, "Cadastro Realizado com sucesso!", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }
            });
    }

    public void salvaruser(){
        String emaildb = editEmail.getText().toString();

        FirebaseUser usuarioLogado = FirebaseAuth.getInstance().getCurrentUser();

        String getUID = usuarioLogado.getUid();

        referencia.child(getUID).child("email").setValue(emaildb);
        referencia.child(getUID).child("notas").child("nota1").setValue("bem-vindo!");

    }

    public void loginscreen(View view){

        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}