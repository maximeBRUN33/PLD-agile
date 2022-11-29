package Modele;

import java.util.*;
//classe Livreur
public class Parcours {
    
	// Attributs
    private ArrayList<Chemin> listeChemins;
    private ArrayList<Livraison> listeLivraisons;
    private Livreur livreur;
    private double heureDepart;
    private double heureArrivee;

    //Constructeur
    public Parcours (ArrayList<Chemin> argListeChemins, ArrayList<Livraison> argListeLivraisons, Livreur argLivreur){
        listeChemins = argListeChemins;
        listeLivraisons = argListeLivraisons;
        livreur = argLivreur;
        heureDepart = listeChemins.get(0).getHeureDepart();
        heureArrivee = listeChemins.get(listeChemins.size() - 1).getHeureArrivee();
    }

    //Méthodes
    public ArrayList<Chemin> getListeChemins() {
		  return listeChemins;
    }    

    public ArrayList<Livraison> getListeLivraisons() {
		  return listeLivraisons;
    }    

    public Livreur getLivreur() {
		  return livreur;
    }    

    public double getHeureDepart() {
		  return heureDepart;
    }    

    public double getHeureArrivee() {
        return heureArrivee;
  }    
}

