package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class filmDescription extends AppCompatActivity {
    TextView description;
    TextView titreFilm;
    TextView producteur;
    TextView realisateur;
    TextView annnes;
    TextView genre;
    Film actuel;
    ImageView imagestar;
    ImageView firstStar;
    BottomNavigationView bottomNavigationView;

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
        bottomNavigationView = findViewById(R.id.barnavigationdescription);
        String titre = getIntent().getStringExtra("titre");
        titreFilm = findViewById(R.id.titrefilm);

        actuel = BD.findFilm(titre);
        description.setText(actuel.getDescription());
        titreFilm.setText(actuel.getTitre());
        annnes.setText(actuel.getAnnees());
        genre.setText(actuel.getGenres());
        producteur.setText(actuel.getProducteur());
        realisateur.setText(actuel.getRealistaeur());
        //bar de navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeNavigation) {
                Intent intent = new Intent(this, SuggestionFilm.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.favoriNavigation) {
                Intent intent = new Intent(this, favoris.class);
                startActivity(intent);

                return true;
            } else if (item.getItemId() == R.id.humeurNavigation) {
                Intent intent = new Intent(this, choisirHumeur.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.profilNavigation) {

                return true;
            }

            return false;
        });


    }

    public void clickImages(View v) {
        if (!(actuel.isFavori())) {
            imagestar.setImageResource(R.mipmap.yellowstar_foreground);
            actuel.setFavori(true);
        } else {
            imagestar.setImageResource(R.mipmap.transpartentstar_foreground);
            actuel.setFavori(false);
        }

    }

    ;

    public void click1Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(1);

        for (int i = 1; i < 2; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 2; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }


    }

    public void click2Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(2);

        for (int i = 1; i < 3; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 3; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    public void click3Star(View v) {

        View temp = findViewById(R.id.page);
        actuel.setNote(3);

        for (int i = 1; i < 4; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 4; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);

            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    public void click4Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(4);

        for (int i = 1; i < 5; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 5; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);

            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    public void click5Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(5);

        for (int i = 1; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.yellowstar_foreground);
        }

    }
}