package com.agile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.agile.Model.*;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
		private static Intersection[] mapIntersections;
		private static Segment[] mapSegments;
		
		
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("initElement"));
        stage.setScene(scene);
				stage.setResizable(false);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}