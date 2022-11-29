package application;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Modele.Intersection;
import Modele.Segment;
import Modele.Warehouse;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

   
public class ParserXML {  
    /**
     * @param args
     */
    public static map getMap() {  

      try {
        
        //Get le fichier XML

        File inputFile = new File("src/application/smallMap.xml");
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
        HashMap<String, Intersection> mapInter = new HashMap<String, Intersection>();
        NodeList listIntersection = doc.getElementsByTagName("intersection");
        for (int temp = 0; temp < listIntersection.getLength(); temp++) {
          Node nInter = listIntersection.item(temp);
          Element eInter = (Element) nInter;
          String id = eInter.getAttribute("id");
          String longitude = eInter.getAttribute("longitude");
          String latitude = eInter.getAttribute("latitude");
          Intersection inter = new Intersection(id, longitude, latitude);
          mapInter.put(id, inter);
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

        map xmlMap = new map(ware, mapInter, listSeg);
        return xmlMap;
         
     } catch (Exception e) {
        e.printStackTrace();
        return null;  
      }
    }
}  