package com.agile.Model;

import java.util.*;
//classe Deliverer
public class Tour {
    
	// Attributs
    private ArrayList<Path> listPaths;
    private ArrayList<Delivery> listDeliveries;
    private Deliverer deliverer;
    private double startHour;
    private double arrivalHour;

    //Constructeur
    public Tour (ArrayList<Path> argListPaths, ArrayList<Delivery> argListDeliveries, Deliverer argDeliverer){
        listPaths = argListPaths;
        listDeliveries = argListDeliveries;
        deliverer = argDeliverer;
        startHour = listPaths.get(0).getStartHour();
        arrivalHour = listPaths.get(listPaths.size() - 1).getArrivalHour();
    }

    //Méthodes
    public ArrayList<Path> getListPaths() {
		  return listPaths;
    }    

    public ArrayList<Delivery> getListDeliveries() {
		  return listDeliveries;
    }    

    public Deliverer getDeliverer() {
		  return deliverer;
    }    

    public double getStartHour() {
		  return startHour;
    }    

    public double getArrivalHour() {
        return arrivalHour;
  }    
}

