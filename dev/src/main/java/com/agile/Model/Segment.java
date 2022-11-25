package com.agile.Model;

public class Segment {
    // Attributs
    private String name;
    private double length;
    private Intersection start;
    private Intersection end;
    	
    //Constructeur
    public Segment (String argName, double argLength, Intersection argStart, Intersection argEnd){
        name = argName;
        length = argLength;
        start = argStart;
        end = argEnd;
    }

    //Méthodes
    public String getname() {
		  return name;
    } 

    public double getLength() {
		  return length;
    } 

    public Intersection getStart() {
		  return start;
    } 

    public Intersection getEnd() {
		  return end;
    } 
}
