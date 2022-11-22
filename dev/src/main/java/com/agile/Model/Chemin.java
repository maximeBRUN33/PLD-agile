package com.agile.Model;

import java.util.ArrayList;
//classe Livreur
public class Chemin {
    
	// Attributs
    private ArrayList<Segment> listeSegments;
    private Intersection depart;
    private Intersection arrivee;
    private double longueur;
    private double heureDepart;
    private double heureArrivee;

    //Constructeur
    public Chemin (ArrayList<Segment> argListeSegments){
        listeSegments = argListeSegments;
        depart = listeSegments.get(0).getDepart();
        arrivee = listeSegments.get(listeSegments.size() - 1).getArrivee();
        longueur = 0;
        listeSegments.forEach((s) -> {
            longueur = longueur + s.getLongueur();
        });
    }

    //Méthodes
    public ArrayList<Segment> getListeSegments() {
		  return listeSegments;
    }    

    public Intersection getDepart() {
		  return depart;
    }    

    public Intersection getArrivee() {
		  return arrivee;
    }    

    public double getLongueur() {
		  return longueur;
    }    

    public double getHeureDepart() {
        return heureDepart;
  }    

  public double getHeureArrivee() {
        return heureArrivee;
  }
}

