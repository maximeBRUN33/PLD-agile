package com.agile.Model;

import java.util.ArrayList;
//classe Deliverer
public class Path {
    
	// Attributs
    private ArrayList<Segment> listSegments;
    private Intersection start;
    private Intersection end;
    private double length;
    private double startHour;
    private double arrivalHour;

    //Constructeur
    public Path (ArrayList<Segment> argListSegments){
        listSegments = argListSegments;
        start = listSegments.get(0).getStart();
        end = listSegments.get(listSegments.size() - 1).getEnd();
        length = 0;
        listSegments.forEach((s) -> {
            length = length + s.getLength();
        });
    }

    //Méthodes
    public ArrayList<Segment> getListSegments() {
		  return listSegments;
    }    

    public Intersection getStart() {
		  return start;
    }    

    public Intersection getEnd() {
		  return end;
    }    

    public double getLength() {
		  return length;
    }    

    public double getStartHour() {
        return startHour;
  }    

  public double getArrivalHour() {
        return arrivalHour;
  }
}

