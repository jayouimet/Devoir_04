package com.example.devoir4film;

import android.util.Log;

import java.util.ArrayList;

public class Film {
    private String titre;
    private float note;
    private boolean favori;
    private String duree;
    private ArrayList<String> humeurlist;

    public String getDuree() {
        return duree;
    }

    public Film(String titre){
        humeurlist=new ArrayList<>();
        for(int i=0;i<3;i++){
            int indextemp=(int)(Math.random()*Humeur.listHumeur.length);
            humeurlist.add(Humeur.listHumeur[indextemp]);
        }

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
}
