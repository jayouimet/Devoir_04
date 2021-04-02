package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class SuggestionFilm extends AppCompatActivity {
    BottomNavigationView bottomNavigationMenu;
    ArrayList<Film> tabfilm;
    ListView maListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        maListView=findViewById(R.id.listsuggestion);
        bottomNavigationMenu=findViewById(R.id.barnavsuggestion);
        tabfilm=new ArrayList<>();
        for(int i=1;i<26;i++){
            Film temp=new Film("Film #"+i);
            tabfilm.add(temp);

        }
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;


        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Film temp: tabfilm
        ) {
            map = new HashMap<>();
            map.put("titre", temp.getTitre());
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            map.put("note", ""+temp.getNote());
            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listItem.add(map);

        }
        /*
        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.rangeseance,
                new String[] { "titre", "note"}, new int[] { R.id.titre, R.id.description});


        //On attribue à notre listView l'adapter que l'on vient de créer
        maListView.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListView.getItemAtPosition(position);



            }
        });*/
        //bar de navigation
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.homeNavigation){

                return true;
            }
            else if(item.getItemId()==R.id.favoriNavigation){

                return true;
            }
            else if(item.getItemId()==R.id.humeurNavigation){

                return true;
            }
            else if(item.getItemId()==R.id.profilNavigation){

                return true;
            }

            return false;
        });
    }
}