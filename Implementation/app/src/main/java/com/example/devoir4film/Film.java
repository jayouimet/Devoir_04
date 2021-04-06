package com.example.devoir4film;

import java.util.ArrayList;

public class Film {
    private String titre;
    private float note;
    private boolean favori;
    private String duree;
    private ArrayList<String> humeurlist;
    private String description;

    public String getDuree() {
        return duree;
    }

    public Film(String titre){
        humeurlist=new ArrayList<>();
        for(int i=0;i<3;i++){
            int indextemp=(int)(Math.random()* BD.listHumeur.length);
            humeurlist.add(BD.listHumeur[indextemp]);
        }
        this.description="Shrek, un ogre verdâtre, découvre de petites créatures agaçantes qui errent dans son marais. Shrek se rend alors au château du seigneur Lord Farquaad, qui aurait soi-disant expulsé ces êtres de son royaume. Ce dernier souhaite épouser la princesse Fiona, mais celle-ci est retenue prisonnière par un abominable dragon. Il lui faut un chevalier assez brave pour secourir la belle. Shrek accepte d'accomplir cette mission.";
        this.titre=titre;
        note=4;
        duree="2h09";
        favori=false;

    }

    public String getTitre() {
        return titre;
    }

    public float getNote() {
        return note;
    }

    public boolean isFavori() {
        return favori;
    }

    public ArrayList<String> getHumeurlist() {
        return humeurlist;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void setFavori(boolean favori) {
        this.favori = favori;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }
}
