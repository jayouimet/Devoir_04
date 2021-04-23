package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreationCompte extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        // Lorsque l'utilisateur clique sur le bouton « Créer le comte », il est amené vers la page « choisirHumeur »
        final Button button = findViewById(R.id.btCreerCompte);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CreationCompte.this, choisirHumeur.class);
                startActivity(intent);
            }
        });
    }
    public void retourConnexionCreation(View v){
        this.finish();
    }
}