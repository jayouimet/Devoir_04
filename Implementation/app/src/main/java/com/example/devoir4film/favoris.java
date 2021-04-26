package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class favoris extends AppCompatActivity {
    private BottomNavigationView bottomNavigationMenu;
    private ArrayList<Film> tabfilm;
    private ListView maListView;
    private EditText inputRechercher;
    private ImageButton favoritesReturnButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        //va chercher les elements visuels
        maListView = findViewById(R.id.listfavori);
        bottomNavigationMenu = findViewById(R.id.barnavfav);
        inputRechercher = findViewById(R.id.barrerechercheselonhumeurfavoris);
        favoritesReturnButton = findViewById(R.id.favoritesReturnButton);

        bottomNavigationMenu.setSelectedItemId(R.id.favoriNavigation);

        tabfilm = BD.tabfilm;


        //remplit liste
        updateListView("");
        //si barre recherche change
        inputRechercher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //lorsque le texte change, la vue s'update
                updateListView("" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //bar de navigation
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeNavigation) {
                Intent intent=new Intent(this,SuggestionFilm.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.favoriNavigation) {

                return true;
            } else if (item.getItemId() == R.id.humeurNavigation) {
                Intent intent=new Intent(this,choisirHumeur.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.profilNavigation) {
                Intent intent = new Intent(this, ParametresCompte.class);
                startActivity(intent);
                return true;
            }

            return false;
        });

        favoritesReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeActivity();
            }
        });
    }

    public void updateListView(String stringDepart) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        int longueur = stringDepart.length();
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Film temp : tabfilm
        ) {
            if (temp.isFavori()) {
                for (int i = 0; i < temp.getHumeurlist().size(); i++) {

                    if (longueur <= temp.getHumeurlist().get(i).length() && stringDepart.equalsIgnoreCase(temp.getHumeurlist().get(i).substring(0, longueur))) {
                        map = new HashMap<>();
                        map.put("titre", temp.getTitre() );
                        map.put("note",temp.getNote() + "/5");
                        //met les informations dans les elements
                        map.put("duree", temp.getDuree());

                        map.put("img", String.valueOf(R.mipmap.yellowstar_foreground));


                        listItem.add(map);
                        break;
                    }
                }
            }

        }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.rangefilmsuggestion,
                new String[]{"titre", "duree", "img","note"}, new int[]{R.id.titrenote, R.id.dureetextbox, R.id.imageetoile,R.id.notefilm});


        //On attribue à notre listView l'adapter que l'on vient de créer
        maListView.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListView.setOnItemClickListener((a, v, position, id) -> {
            //on récupère la HashMap contenant les infos de notre item (titre, description, img)

            HashMap<String, String> map1 = (HashMap<String, String>) maListView.getItemAtPosition(position);
            Intent intent=new Intent(this,filmDescription.class);
            intent.putExtra("titre",map1.get("titre"));

            startActivity(intent);


        });
    }

    /**
     * Fermeture de l'activité Favoris
     */
    private void closeActivity() {
        this.finish();
    }
}