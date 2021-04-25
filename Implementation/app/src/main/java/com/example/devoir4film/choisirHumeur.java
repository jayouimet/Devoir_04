package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class choisirHumeur extends AppCompatActivity {
    GridView gridView;
    EditText editText;
    ImageButton chooseMoodReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_humeur);
        //va chercher les elements visuels
        gridView = findViewById(R.id.gridhumeur);
        editText = findViewById(R.id.searchMoodTextView);
        chooseMoodReturnButton = findViewById(R.id.chooseMoodReturnButton);
        updateListView("");//met les elements dans la grid
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //si barre recherche change
                updateListView("" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        chooseMoodReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackHumeur();
            }
        });
    }

    public void updateListView(String stringDepart) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        int longueur = stringDepart.length();
        HashMap<String, Integer> mapEmotion = BD.getMapEmotion();
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (String temp : BD.listHumeur
        ) {
            if (longueur <= temp.length() && stringDepart.equalsIgnoreCase(temp.substring(0, longueur))) {
                map = new HashMap<>();
                //met le titre de lhumeur
                map.put("titre", temp);
                listItem.add(map);
                Integer numImg = mapEmotion.get(temp);
                if (!(numImg==null)) {
                    map.put("img", String.valueOf(numImg));
                }
                else{
                    map.put("img", String.valueOf(R.mipmap.neutral_foreground));
                }
            }
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chaque humeur)
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.elementpagehumeur,
                new String[]{"titre","img"}, new int[]{R.id.titrehumeur,R.id.imageutilisateurmessage});


        //On attribue à notre listView l'adapter que l'on vient de créer
        gridView.setAdapter(mSchedule);
        /*favorie.setOnClickListener(v -> {
            favorie.setImageResource(R.mipmap.yellowstar_foreground);
        });*/
        //Enfin on met un écouteur d'évènement sur notre listView
        gridView.setOnItemClickListener((a, v, position, id) -> {
            //on récupère la HashMap contenant les infos de notre item (titre, description, img)
            HashMap<String, String> map1 = (HashMap<String, String>) gridView.getItemAtPosition(position);
            String titre = map1.get("titre");
            BD.user.setHumeur(titre);
            //change dacivite en changeant humeur
            Intent intent = new Intent(this, SuggestionFilm.class);
            startActivity(intent);


        });
    }
    public void goBackHumeur(){
        this.finish();
    }
}