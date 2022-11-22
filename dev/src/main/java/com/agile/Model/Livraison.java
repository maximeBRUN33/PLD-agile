package com.agile.Model;

//classe Livreur
public class Livraison {
    
	// Attributs
    private double heureDepart;
    private double heureArrivee;
    private Intersection lieu;
    private Livreur livreur;

    //Constructeur
    public Livraison (double argHeureDepart, double argHeureArrivee, Intersection argLieu, Livreur argLivreur){
        heureDepart = argHeureDepart;
        heureArrivee = argHeureArrivee;
        lieu = argLieu;
        livreur = argLivreur;
    }

    //Méthodes
    public double getHeureDepart() {
		  return heureDepart;
    }    

    public double getHeureArrivee() {
		  return heureArrivee;
    }    

    public Intersection getLieu() {
		  return lieu;
    }    

    public Livreur getLivreur() {
		  return livreur;
    }    
}

