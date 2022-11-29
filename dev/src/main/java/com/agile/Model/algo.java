package com.agile.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;  

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

   
public class algo {  
    /**
     * @param args
     */
    public static void main(String[] args) {  

      try {
        
        //Get le fichier XML

        File inputFile = new File("/Users/antoinevraux/Documents/INSA 4IF/PLD-agile/dev/src/main/java/com/agile/Model/smallMap.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        //Get le Warehouse
        NodeList listWarehouse = doc.getElementsByTagName("warehouse");
        Node warehouse = listWarehouse.item(0);
        Element eWarehouse = (Element) warehouse;
        String wareAddress= eWarehouse.getAttribute("address");
        Warehouse ware = new Warehouse(wareAddress);

        //Get les intersections
        List<Intersection> listInter = new ArrayList<Intersection>();
        NodeList listIntersection = doc.getElementsByTagName("intersection");
        for (int temp = 0; temp < listIntersection.getLength(); temp++) {
          Node nInter = listIntersection.item(temp);
          Element eInter = (Element) nInter;
          String id = eInter.getAttribute("id");
          String longitude = eInter.getAttribute("longitude");
          String latitude = eInter.getAttribute("latitude");
          Intersection inter = new Intersection(id, longitude, latitude);
          listInter.add(inter);
        } 

        //Get les segments
        List<Segment> listSeg = new ArrayList<Segment>();
        NodeList listSegment = doc.getElementsByTagName("segment");
        for (int temp = 0; temp < listSegment.getLength(); temp++) {
          Node nSeg = listSegment.item(temp);
          Element eSeg = (Element) nSeg;
          String destination = eSeg.getAttribute("destination");
          String length = eSeg.getAttribute("length");
          String name = eSeg.getAttribute("name");
          String origin = eSeg.getAttribute("origin");
          Segment seg = new Segment(name, length, origin, destination);
          listSeg.add(seg);
        }

        map xmlMap = new map(ware, listInter, listSeg);
        System.out.println(xmlMap);
         
     } catch (Exception e) {
        e.printStackTrace();
      }  
    }
}  