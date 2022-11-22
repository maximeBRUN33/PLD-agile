package com.agile.Model;

public class Intersection {
    // Attributs
    private String id;
    private double longitude;
    private double latitude;
    	
    //Constructeur
    public Intersection (String argId, double argLongitude, double argLatitude){
        id = argId;
        longitude = argLongitude;
        latitude = argLatitude;
    }

    //Méthodes
    public String getId() {
		return id;
    } 

    public double getLongitude() {
		return longitude;
    } 

    public double getLatitude() {
		return latitude;
    } 
}
