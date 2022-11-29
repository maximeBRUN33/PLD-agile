package com.agile.Model;

public class Intersection {
    // Attributs
    private String id;
    private String longitude;
    private String latitude;
    	
    //Constructeur
    public Intersection (String argId, String argLongitude, String argLatitude){
        id = argId;
        longitude = argLongitude;
        latitude = argLatitude;
    }

    //Méthodes
    public String getId() {
		return id;
    } 

    public String getLongitude() {
		return longitude;
    } 

    public String getLatitude() {
		return latitude;
    }

    public void setId(String id) {
      this.id = id;
    }

    public void setLongitude(String longitude) {
      this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
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
