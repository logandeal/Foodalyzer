 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logandeal.finalprojectfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

/**
 *
 * @author logan
 */
public class Foodalyzer extends Application {
    
    static ArrayList<Restaurant> restaurants = null; 
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MyFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Foodalyzer");
        stage.setScene(scene);
        stage.show();
        restaurants = new ArrayList<>();
        System.out.println("-- Welcome to Foodalyzer! --");
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}