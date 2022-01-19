package com.herorickystudios.notepaddocdoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.Calendar;

//Programado por HeroRickyGames

public class add_Note extends AppCompatActivity {

    Toolbar toolbar;
    EditText noteTitle, noteDetails;
    Calendar c;
    String todaysDate;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Nova nota");
        noteTitle = findViewById(R.id.noteTitle);
        noteDetails = findViewById(R.id.noteDetails);

        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //salvar no db o que esta sendo digitado aqui
                //Lembra-te disso.

                if(charSequence.length() != 0 ){

                    getSupportActionBar().setTitle(charSequence);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        c = Calendar.getInstance();

        todaysDate = c.get(Calendar.DAY_OF_MONTH) +"/" + (c.get(Calendar.MONTH)+ 1 ) + "/" + c.get(Calendar.YEAR) + " Dia da Semana: " + c.get(Calendar.DAY_OF_WEEK);

        currentTime = pad (c.get(Calendar.HOUR))+ "+" + pad(c.get(Calendar.MINUTE));

        Log.d("Calendario", "Data e hora " + todaysDate + " and " + currentTime );

    }

    private String pad(int i) {
        if(i<10)
            return "0" + i;
        return String.valueOf(i);
    }
}