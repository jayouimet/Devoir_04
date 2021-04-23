package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

public class ParametresCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres_compte);
    }

    //Lorsque l'utilisateur clique sur la flèche, il est ramené vers la page précédente, soit la page «Mon Profil»
    public void quitterParametresCompte(View v){
        this.finish();
    }
    public void deconnexion(View v){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}