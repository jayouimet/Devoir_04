package com.example.devoir4film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
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
    EditText inputRechercher;
    ImageView favorie;
    Utilisateur actuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        actuel=BD.user;//utilisateur
        //trouve les elements visuels
        maListView = findViewById(R.id.listsuggestion);
        bottomNavigationMenu = findViewById(R.id.barnavsuggestion);
        inputRechercher = findViewById(R.id.barrerechercheselonhumeur);
        favorie=findViewById(R.id.imageetoile);
        tabfilm = BD.tabfilm;
        //remplit la liste view
        updateListView("",true);
        inputRechercher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //lorsque le texte change, la vue s'update
                updateListView("" + s,false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //bar de navigation
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.homeNavigation) {

                return true;
            } else if (item.getItemId() == R.id.favoriNavigation) {
                Intent intent=new Intent(this,favoris.class);
                startActivity(intent);

                return true;
            } else if (item.getItemId() == R.id.humeurNavigation) {
                Intent intent=new Intent(this,choisirHumeur.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.profilNavigation) {

                return true;
            }

            return false;
        });

    }

    /**
     * update la list view
     * @param stringDepart comment ca doit commencer pour afficher
     * @param firstlook si est la premiere fois affiche ou upate a cause text change
     */
    public void updateListView(String stringDepart,boolean firstlook) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        int longueur = stringDepart.length();
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Film temp : tabfilm
        ) {
            for (int i = 0; i < temp.getHumeurlist().size(); i++) {

                if (longueur <= temp.getHumeurlist().get(i).length() && stringDepart.equalsIgnoreCase(temp.getHumeurlist().get(i).substring(0, longueur))&&!firstlook) {
                    map = new HashMap<>();
                    map.put("titre", temp.getTitre() + "  " + temp.getNote() + "/5");



                    //on insere les divers info
                    map.put("duree", temp.getDuree());
                    if(temp.isFavori()){
                        map.put("img",String.valueOf(R.mipmap.yellowstar_foreground));
                    }
                    else{
                        map.put("img",String.valueOf(R.mipmap.transpartentstar_foreground));
                    }
                    listItem.add(map);
                    break;

                }
                //si cest la premiere fois affiche tout film qui a bonne humeur
                else if(firstlook&&actuel.getHumeur().equalsIgnoreCase(temp.getHumeurlist().get(i))){
                    map = new HashMap<>();
                    map.put("titre", temp.getTitre() + "  " + temp.getNote() + "/5");

                    //on insire diverse informations
                    map.put("duree", temp.getDuree());
                    if(temp.isFavori()){
                        map.put("img",String.valueOf(R.mipmap.yellowstar_foreground));
                    }
                    else{
                        map.put("img",String.valueOf(R.mipmap.transpartentstar_foreground));
                    }
                    listItem.add(map);
                    break;
                }
            }

        }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chaque film)
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.rangefilmsuggestion,
                new String[]{"titre", "duree","img"}, new int[]{R.id.titrenote, R.id.dureetextbox,R.id.imageetoile});


        //On attribue à notre listView l'adapter que l'on vient de créer
        maListView.setAdapter(mSchedule);
        /*favorie.setOnClickListener(v -> {
            favorie.setImageResource(R.mipmap.yellowstar_foreground);
        });*/
        //Enfin on met un écouteur d'évènement sur notre listView
        maListView.setOnItemClickListener((a, v, position, id) -> {
            //on récupère la HashMap contenant les infos de notre item (titre)
            HashMap<String, String> map1 = (HashMap<String, String>) maListView.getItemAtPosition(position);
            Intent intent=new Intent(this,filmDescription.class);
            startActivity(intent);


        });
    }


}