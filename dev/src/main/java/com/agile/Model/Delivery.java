package com.agile.Model;

//classe Deliverer
public class Delivery {
    
	// Attributs
    private double startHour;
    private double arrivalHour;
    private Intersection place;
    private Deliverer deliverer;

    //Constructeur
    public Delivery (double argStartHour, double argArrivalHour, Intersection argPlace, Deliverer argDeliverer){
        startHour = argStartHour;
        arrivalHour = argArrivalHour;
        place = argPlace;
        deliverer = argDeliverer;
    }

    //Méthodes
    public double getStartHour() {
		  return startHour;
    }    

    public double getArrivalHour() {
		  return arrivalHour;
    }    

    public Intersection getPlace() {
		  return place;
    }    

    public Deliverer getDeliverer() {
		  return deliverer;
    }    
}

