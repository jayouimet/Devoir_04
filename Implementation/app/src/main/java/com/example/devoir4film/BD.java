package com.example.devoir4film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BD {
   public static Utilisateur user=new Utilisateur();
   public static String[] listHumeur={"Fâché","Neutre","Fatigué","Drôle","Party","Heureux","Amoureux","Triste","Horreur","Dépressif","Étrange","Curieux"};
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
   public static HashMap<String,Integer> getMapEmotion(){
      HashMap<String,Integer> lienEmotionImage=new HashMap<>();
      lienEmotionImage.put("Fâché",R.mipmap.angryreact_foreground);
      lienEmotionImage.put("Amoureux",R.mipmap.lovereact_foreground);
      lienEmotionImage.put("Neutre",R.mipmap.neutral_foreground);
      lienEmotionImage.put("Fatigué",R.mipmap.tired_foreground);
      lienEmotionImage.put("Drôle",R.mipmap.funny_foreground);
      lienEmotionImage.put("Party",R.mipmap.party_foreground);
      lienEmotionImage.put("Heureux",R.mipmap.happy_foreground);
      lienEmotionImage.put("Triste",R.mipmap.sad_foreground);
      lienEmotionImage.put("Horreur",R.mipmap.fear_foreground);
      lienEmotionImage.put("Dépressif",R.mipmap.depressed_foreground);
      lienEmotionImage.put("Curieux",R.mipmap.curious_foreground);
      lienEmotionImage.put("Étrange",R.mipmap.ovni_foreground);
      return lienEmotionImage;

   }

}
