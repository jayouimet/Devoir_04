package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class filmDescription extends AppCompatActivity {
    TextView description;
    TextView titreFilm;
    TextView producteur;
    TextView realisateur;
    TextView annnes;
    TextView genre;
    Film actuel;
    ImageView imagestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);
        description = findViewById(R.id.descriptionfilm);
        producteur = findViewById(R.id.producteur);
        realisateur = findViewById(R.id.realisateur);
        genre = findViewById(R.id.genres);
        annnes = findViewById(R.id.annees);
        imagestar = findViewById(R.id.imagestardescription);
        String titre = getIntent().getStringExtra("titre");
        titreFilm = findViewById(R.id.titrefilm);

        actuel = BD.findFilm(titre);
        description.setText(actuel.getDescription());
        titreFilm.setText(actuel.getTitre());
        annnes.setText(actuel.getAnnees());
        genre.setText(actuel.getGenres());
        producteur.setText(actuel.getProducteur());
        realisateur.setText(actuel.getRealistaeur());
        imagestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(actuel.isFavori())) {
                    imagestar.setImageResource(R.mipmap.yellowstar_foreground);
                    actuel.setFavori(true);
                }else {
                    imagestar.setImageResource(R.mipmap.transpartentstar_foreground);
                    actuel.setFavori(false);
                }

            }
        });

    }
}