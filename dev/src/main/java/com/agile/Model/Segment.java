package com.agile.Model;

public class Segment {
    // Attributs
    private String name;
    private String length;
    private String origin;
    private String destination;
    	
    //Constructeur
    public Segment (String argName, String argLength, String argOrigin, String argDestination){
        name = argName;
        length = argLength;
        origin = argOrigin;
        destination = argDestination;
    }

    //Méthodes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Segment [name=" + name + ", length=" + length + ", origin=" + origin + ", destination=" + destination
                + "]";
    }
    
}


