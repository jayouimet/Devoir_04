package com.example.devoir4film;

public class Utilisateur {
    private String humeur;
    public Utilisateur(){
        this.humeur="Neutre";
    }

    public void setHumeur(String humeur) {
        this.humeur = humeur;
    }

    public String getHumeur() {
        return humeur;
    }
}
