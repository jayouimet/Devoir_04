package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

public class filmDescription extends AppCompatActivity {
    TextView description;
    TextView titreFilm;
    TextView producteur;
    TextView realisateur;
    TextView annnes;
    TextView genre;
    Film actuel;
    ImageView imagestar;
    ImageView premiereEmotion;
    ImageView deuxiemeEmotion;
    ImageView troisiemeEmotion;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);
        //va chercher les elements visuels de la page
        description = findViewById(R.id.descriptionfilm);
        producteur = findViewById(R.id.producteur);
        realisateur = findViewById(R.id.realisateur);
        genre = findViewById(R.id.genres);
        annnes = findViewById(R.id.annees);
        imagestar = findViewById(R.id.imagestardescription);
        bottomNavigationView = findViewById(R.id.barnavigationdescription);
        //va chercher le titre du film
        String titre = getIntent().getStringExtra("titre");
        titreFilm = findViewById(R.id.titrefilm);
        premiereEmotion = findViewById(R.id.premiereemotion);
        deuxiemeEmotion=findViewById(R.id.deuxiemeemotion);
        troisiemeEmotion=findViewById(R.id.troisiemeemotion);
        actuel = BD.findFilm(titre);//va chercher le film dans la BD

        description.setText(actuel.getDescription());
        ///met les informations a leur endroit
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
        if(actuel.isFavori()){
            imagestar.setImageResource(R.mipmap.yellowstar_foreground);
        }
        HashMap<String, Integer> mapEmotion = BD.getMapEmotion();
        //met les emoticones pour les emotions correspondantes
        Integer numImgPremiere = mapEmotion.get(actuel.getHumeurlist().get(0));
        if (numImgPremiere != null) {
            premiereEmotion.setImageResource(numImgPremiere);
        } else {
            premiereEmotion.setImageResource(R.mipmap.neutral_foreground);
        }
        Integer numImgDeux = mapEmotion.get(actuel.getHumeurlist().get(1));
        if (numImgDeux != null) {
            deuxiemeEmotion.setImageResource(numImgDeux);
        } else {
            deuxiemeEmotion.setImageResource(R.mipmap.neutral_foreground);
        }
        Integer numImgTrois = mapEmotion.get(actuel.getHumeurlist().get(2));
        if (numImgTrois != null) {
            troisiemeEmotion.setImageResource(numImgTrois);
        } else {
            troisiemeEmotion.setImageResource(R.mipmap.neutral_foreground);
        }


    }
    //change l'image de favori
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

    /**
     * si clique 1 etoile
     * @param v image de une etoile
     */
    public void click1Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(1);

        for (int i = 1; i < 2; i++) {
            ImageView star = temp.findViewWithTag("star" + i);

            //la premiere etoile jaune
            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 2; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);

            //reste transparent
            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }


    }

    /**
     * met 2 etoile jaune
     * @param v
     */
    public void click2Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(2);

        for (int i = 1; i < 3; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            //2 premiere etoile jaune

            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 3; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            //reste transparent

            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    /**
     * met 3 etoile jaune
     * @param v
     */
    public void click3Star(View v) {

        View temp = findViewById(R.id.page);
        actuel.setNote(3);

        for (int i = 1; i < 4; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            //met 3 premiere jaune

            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 4; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            //reste transparent
            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    /**
     * met 4 etoile jaune
     * @param v
     */
    public void click4Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(4);
        //met 4 premiere jaune
        for (int i = 1; i < 5; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            star.setImageResource(R.mipmap.yellowstar_foreground);
        }
        for (int i = 5; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);
            //la derniere est transparentes
            star.setImageResource(R.mipmap.transpartentstar_foreground);
        }
    }

    /**
     * met 5 etoiles transparentes
     * @param v
     */
    public void click5Star(View v) {
        View temp = findViewById(R.id.page);
        actuel.setNote(5);
        //met tout jaune
        for (int i = 1; i < 6; i++) {
            ImageView star = temp.findViewWithTag("star" + i);


            star.setImageResource(R.mipmap.yellowstar_foreground);
        }

    }
    public void goBackDescription(View v){
        this.finish();
    }
}