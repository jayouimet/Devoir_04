package com.example.devoir4film;

import java.util.ArrayList;

public class Film {
    private String titre;
    private float note;
    private boolean favori;
    private String duree;
    private ArrayList<String> humeurlist;
    private String description;
    private String producteur;
    private String realistaeur;
    private String annees;
    private String[] banqueGenre={"Action","Comédie","Horreur","Aventure","Drame","Suspense","Comedie Romantique","Fantastique","Super-Heros","Science-Fiction"};
    private String genres;

    public String getDuree() {
        return duree;
    }

    public Film(String titre){
        humeurlist=new ArrayList<>();
        for(int i=0;i<3;i++){
            int indextemp=(int)(Math.random()* BD.listHumeur.length);
            humeurlist.add(BD.listHumeur[indextemp]);
        }
        this.producteur="Micheal Bay";
        this.realistaeur="Quentin Tarentino";
        this.annees="2012";
        String genre1=banqueGenre[(int)(Math.random()*banqueGenre.length)];
        String genre2=banqueGenre[(int)(Math.random()*banqueGenre.length)];
        if(!(genre1.equalsIgnoreCase(genre2))){
            this.genres=genre1+","+genre2;
        }
        else{
            this.genres=genre1;
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

    public String getProducteur() {
        return producteur;
    }

    public String getRealistaeur() {
        return realistaeur;
    }

    public String getAnnees() {
        return annees;
    }

    public String[] getBanqueGenre() {
        return banqueGenre;
    }

    public String getGenres() {
        return genres;
    }
}
