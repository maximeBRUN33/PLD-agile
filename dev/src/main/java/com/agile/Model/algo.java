package com.agile.Model;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
   
public class algo {  
    public static void main(String[] args) {  
   
     try {  
   
        File file = new File("smallMap.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(map.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        map mapxml = (map) jaxbUnmarshaller.unmarshal(file);  

        Warehouse ware = mapxml.getWarehouse(); 
        System.out.println(ware.toString());  
        List<Segment> listSeg=mapxml.getSegments();  
        for(Segment seg:listSeg)  
          System.out.println(seg.toString());  

        List<Intersection> listInter = mapxml.getIntersections();
        for(Intersection inter:listInter)  
          System.out.println(inter.toString());  
   
      }catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
}  