package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AjouterCompte extends AppCompatActivity {
    ImageView ivPremierCompte;
    TextView tvPremierCompte;
    ImageView ivDeuxiemeCompte;
    TextView tvDeuxiemeCompte;
    ImageView ivTroisiemeCompte;
    TextView tvTroisiemeCompte;
    ImageView ivAjouterCompte;
    TextView tvAjouterCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_compte);



        // Lorsque l'utilisateur clique sur l'icône  du premier compte, il est ramené vers la page « Connexion »
        ivPremierCompte = (ImageView) findViewById(R.id.ivPremierCompte);
        ivPremierCompte.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                         startActivity(intent);
                                                     }
                                                 }
        );

        // Lorsque l'utilisateur clique sur le texte « Premier Compte », il est ramené vers la page « Connexion »
        tvPremierCompte = (TextView) findViewById(R.id.tvPremierCompte);
        tvPremierCompte.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );


        // Lorsque l'utilisateur clique sur l'icône  du deuxième compte, il est ramené vers la page « Connexion »
        ivDeuxiemeCompte = (ImageView) findViewById(R.id.ivDeuxiemeCompte);
        ivDeuxiemeCompte.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );

        // Lorsque l'utilisateur clique sur le texte « Deuxième Compte », il est ramené vers la page « Connexion »
        tvDeuxiemeCompte = (TextView) findViewById(R.id.tvDeuxiemeCompte);
        tvDeuxiemeCompte.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );

        // Lorsque l'utilisateur clique sur l'icône  du troisième compte, il est ramené vers la page « Connexion »
        ivTroisiemeCompte = (ImageView) findViewById(R.id.ivTroisiemeCompte);
        ivTroisiemeCompte.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );

        // Lorsque l'utilisateur clique sur le texte « Troisième Compte », il est ramené vers la page « Connexion »
        tvTroisiemeCompte = (TextView) findViewById(R.id.tvTroisiemeCompte);
        tvTroisiemeCompte.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(AjouterCompte.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );

        // Lorsque l'utilisateur clique sur l'icône  pour ajouter un compte, il est ramené vers la page « Création de compte »
        ivAjouterCompte = (ImageView) findViewById(R.id.ivAjouterCompte);
        ivAjouterCompte.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(AjouterCompte.this, CreationCompte.class);
                                                     startActivity(intent);
                                                 }
                                             }
        );

        // Lorsque l'utilisateur clique sur le texte « Ajouter un compte », il est ramené vers la page « Création de compte »
        tvAjouterCompte = (TextView) findViewById(R.id.tvAjouterCompte);
        tvAjouterCompte.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(AjouterCompte.this, CreationCompte.class);
                                                     startActivity(intent);
                                                 }
                                             }
        );
    }
}