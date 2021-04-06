package com.example.devoir4film;

import java.util.ArrayList;

public class BD {
   public static Utilisateur user=new Utilisateur();
   public static String[] listHumeur={"Fâché","Neutre","Fatigué","Drôle","Party","Heureux","Amoureux","Triste","Horreur","Nostalgique","Dépressif","Curieux"};
   public static ArrayList<Film> tabfilm=createTabFilm();

   /**
    * met des films
    * @return le tableau de film
    */
   private static ArrayList<Film> createTabFilm() {
      ArrayList<Film> tableaufilm = new ArrayList<>();//remplit les films
      for (int i = 1; i < 50; i++) {
         Film temp = new Film("Film #" + i);
         if(i%4==0){
            //met des films en favoris
            temp.setFavori(true);
         }
         tableaufilm.add(temp);

      }
      return tableaufilm;

   }
   public static   Film findFilm(String titre ){
      for (Film temp:tabfilm){
         if(temp.getTitre().equalsIgnoreCase(titre)){
            return temp;
         }

      }
      return null;
   }


}
