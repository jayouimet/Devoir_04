package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class choisirHumeur extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_humeur);
        gridView=findViewById(R.id.gridhumeur);
        updateListView("");
    }
    public void updateListView(String stringDepart) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        int longueur = stringDepart.length();

        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (String temp : BD.listHumeur
        ) {


                if (longueur <= temp.length() && stringDepart.equalsIgnoreCase(temp.substring(0, longueur))) {
                    map = new HashMap<>();
                    map.put("titre", temp);

                    //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml

                    //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml


                    listItem.add(map);




            }

        }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.elementpagehumeur,
                new String[]{"titre"}, new int[]{R.id.titrehumeur});


        //On attribue à notre listView l'adapter que l'on vient de créer
        gridView.setAdapter(mSchedule);
        /*favorie.setOnClickListener(v -> {
            favorie.setImageResource(R.mipmap.yellowstar_foreground);
        });*/
        //Enfin on met un écouteur d'évènement sur notre listView
        gridView.setOnItemClickListener((a, v, position, id) -> {
            //on récupère la HashMap contenant les infos de notre item (titre, description, img)
            HashMap<String, String> map1 = (HashMap<String, String>) gridView.getItemAtPosition(position);
            String titre=map1.get("titre");
            BD.user.setHumeur(titre);
            Intent intent=new Intent(this,SuggestionFilm.class);
            startActivity(intent);


        });
    }
}