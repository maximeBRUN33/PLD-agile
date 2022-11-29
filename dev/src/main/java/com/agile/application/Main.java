package com.agile.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agile.Model.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Main extends Application {
	
	private double mapWidth = 600;
	private double mapHeight = 600;

	private List<Double> getXYFromLatLong(double latitude, double longitude) {

		// get x value
		double x = (longitude+180)*(mapWidth/360);

		// convert from degrees to radians
		double latRad = latitude*Math.PI/180;

		// get y value
		double mercN = Math.log(Math.tan((Math.PI/4)+(latRad/2)));
		double y     = (mapHeight/2)-(mapWidth*mercN/(2*Math.PI));
		
		ArrayList<Double> result = new ArrayList<Double>();
		result.add((x - 308.09) * mapWidth / 0.05);
		result.add((y - 214.02) * mapHeight / 0.05);
		return result ;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			map xmlMap = ParserXML.getMap();
			BorderPane root = new BorderPane();
			Group route = new Group();
			Scene scene = new Scene(route, 600, 600);
			
			HashMap<String, Intersection> mapIntersec = xmlMap.getIntersections();
			
			List<Segment> listeSegments = xmlMap.getSegments();
			
			for(Segment seg: listeSegments) {
				double lat1 = Double.valueOf(mapIntersec.get(seg.getDestination()).getLatitude());
				double long1= Double.valueOf(mapIntersec.get(seg.getDestination()).getLongitude());
				
				double lat2 = Double.valueOf(mapIntersec.get(seg.getOrigin()).getLatitude());
				double long2= Double.valueOf(mapIntersec.get(seg.getOrigin()).getLongitude());
				Line line = new Line();

				// Setting the properties to a line
				line.setStartX(getXYFromLatLong(lat1, long1).get(0));
				line.setStartY(getXYFromLatLong(lat1, long1).get(1));
				line.setEndX(getXYFromLatLong(lat2, long2).get(0));
				line.setEndY(getXYFromLatLong(lat2, long2).get(1));
				line.setStrokeWidth(3.0);
				route.getChildren().add(line); //adding the class object //to the group  
			}
			
			for (Map.Entry<String, Intersection> entry : mapIntersec.entrySet()) {
				Button boutonIntersection = new Button();
				boutonIntersection.setLayoutX(getXYFromLatLong(Double.valueOf(entry.getValue().getLatitude()), Double.valueOf(entry.getValue().getLongitude())).get(0) - 3.5);
				boutonIntersection.setLayoutY(getXYFromLatLong(Double.valueOf(entry.getValue().getLatitude()), Double.valueOf(entry.getValue().getLongitude())).get(1) - 3.5);
				boutonIntersection.setStyle(
		                "-fx-background-radius: 10em; " +
		                "-fx-min-width: 7px; " +
		                "-fx-min-height: 7px; " +
		                "-fx-max-width: 7px; " +
		                "-fx-max-height: 7px;"
		        );
				boutonIntersection.setOnAction(
				        new EventHandler<ActionEvent>() {
				            @Override
				            public void handle(ActionEvent event) {
				                final Stage dialog = new Stage();
				                dialog.initModality(Modality.APPLICATION_MODAL);
				                dialog.initOwner(primaryStage);
				                VBox dialogVbox = new VBox(20);
				                dialogVbox.getChildren().add(new Text(entry.getValue().toString()));
				                dialogVbox.setStyle("-fx-font: 12 Verdana;");
				                Scene dialogScene = new Scene(dialogVbox, 600, 200);
				                dialog.setScene(dialogScene);
				                dialog.show();
				                
				            }
				         });
				route.getChildren().add(boutonIntersection); //adding the class object //to the group 
			}
			

	        route.setStyle("-fx-background-color: black;");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
