package com.agile.Model;

import java.util.List;  
  
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;  
  
@XmlRootElement  
public class map {    
private Warehouse warehouse;  
private List<Intersection> intersections;
private List<Segment> segments;    
public map() {}  
public map(Warehouse warehouse, List<Intersection> intersections, List<Segment> segments ) {  
    super();  
    this.warehouse = warehouse;  
    this.intersections = intersections;  
    this.segments = segments;  
}  
@XmlElement 
public Warehouse getWarehouse() {  
    return warehouse;  
}  
public void setWarehouse(Warehouse warehouse) {  
    this.warehouse = warehouse;  
}  
@XmlElement  
public List<Intersection> getIntersections() {  
    return intersections;  
}  
public void setIntersections(List<Intersection> intersections) {  
    this.intersections = intersections;  
}  
@XmlElement  
public List<Segment> getSegments() {  
    return segments;  
}  
public void setSegments(List<Segment> segments) {  
    this.segments = segments;  
}
@Override
public String toString() {
    return "map [warehouse=" + warehouse + ", intersections=" + intersections + ", segments=" + segments + "]";
}  
}  
