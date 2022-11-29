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

    public void setId(String id) {
      this.id = id;
    }

    public void setLongitude(double longitude) {
      this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
      this.latitude = latitude;
    } 

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
      return "Intersection [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + "]";
    }
}
