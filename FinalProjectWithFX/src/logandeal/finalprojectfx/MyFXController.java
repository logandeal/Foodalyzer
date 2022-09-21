/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package logandeal.finalprojectfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author logan
 */
public class MyFXController implements Initializable {

    @FXML
    private TextField newRestaurantTextBox;
    @FXML
    private Separator separator;
    @FXML
    private Group addNewRestaurantGroup;
    @FXML
    private Button newMenuItemButton;
    @FXML
    private Button getAvgPriceButton;
    @FXML
    private Button getAvgCalPerDollarButton;
    @FXML
    private ListView<Restaurant> restaurantList;
    @FXML
    private ListView<MenuItem> menuItemList;
    @FXML
    private ListView<MenuItem> valueMealForList;
    @FXML
    private Group addNewMenuItemGroup;
    @FXML
    private Group getValueMealForGroup;
    @FXML
    private CheckBox breakfastCheckbox;
    @FXML
    private TextField newMenuItemNameTextBox;
    @FXML
    private TextField newMenuItemPriceTextBox;
    @FXML
    private TextField newMenuItemCaloriesTextBox;
    @FXML
    private TextField getValueMealForTextBox;
    @FXML
    private Label avgPriceTextLabel;
    @FXML
    private Label avgCalPerDollarTextLabel;
    @FXML
    private ChoiceBox getValueMealForChoiceBox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       getValueMealForChoiceBox.getItems().addAll("dollars", "calories", "dollars (breakfast)", "calories (breakfast)");
    }    

    @FXML
    private void newRestaurant(ActionEvent event) {
        separator.setVisible(false);
        addNewMenuItemGroup.setVisible(false);
        addNewRestaurantGroup.setVisible(true);

    }

    @FXML
    private void newMenuItem(ActionEvent event) {
        separator.setVisible(false);
        addNewRestaurantGroup.setVisible(false);
        addNewMenuItemGroup.setVisible(true);
    }

    @FXML
    private void submitNewRestaurant(ActionEvent event) {
        String restaurantEntered = newRestaurantTextBox.getText();
        if (restaurantEntered.isBlank()) 
            throw new EmptyTextBoxException();
        System.out.println(restaurantEntered);
        Restaurant newRestaurant = new Restaurant(restaurantEntered);
        Foodalyzer.restaurants.add(newRestaurant);
        restaurantList.getItems().add(newRestaurant);
        System.out.println("Created new restaurant " + restaurantEntered);
        newRestaurantTextBox.setText("");
        addNewRestaurantGroup.setVisible(false);
        separator.setVisible(true);
        newMenuItemButton.setDisable(false);
    }

    @FXML
    private void restaurantListClicked(MouseEvent event) {
        Restaurant restaurantSelected = restaurantList.getSelectionModel().getSelectedItem();
        if (restaurantSelected != null) {
            System.out.println(restaurantSelected.m_name + " clicked");
            menuItemList.getItems().clear();
            menuItemList.getItems().addAll(restaurantSelected.getAllMenuItems());
            System.out.println("Loaded menu items for " + restaurantSelected);
        }
    }

    @FXML
    private void submitNewMenuItem(ActionEvent event) {
        String nameEntered = newMenuItemNameTextBox.getText();
        String priceEntered = newMenuItemPriceTextBox.getText();
        String caloriesEntered = newMenuItemCaloriesTextBox.getText();
        if (!nameEntered.isBlank() && !priceEntered.isBlank() && !caloriesEntered.isBlank()) {
            Restaurant restaurantSelected = restaurantList.getSelectionModel().getSelectedItem();
            if (restaurantSelected != null) {
                if (breakfastCheckbox.isSelected())
                    restaurantSelected.addNewMenuItem(nameEntered, Float.parseFloat(priceEntered), Integer.parseInt(caloriesEntered), 'b');
                else 
                    restaurantSelected.addNewMenuItem(nameEntered, Float.parseFloat(priceEntered), Integer.parseInt(caloriesEntered), 'd');
                menuItemList.getItems().clear();
                menuItemList.getItems().addAll(restaurantSelected.getAllMenuItems());
                newMenuItemNameTextBox.setText("");
                newMenuItemPriceTextBox.setText("");
                newMenuItemCaloriesTextBox.setText("");
                addNewMenuItemGroup.setVisible(false);
                separator.setVisible(true);
                getAvgPriceButton.setDisable(false);
                getAvgCalPerDollarButton.setDisable(false);
                getValueMealForGroup.setDisable(false);
            }
        }
        else {
            throw new EmptyTextBoxException();
        }
    }
 
    @FXML
    private void getAvgPrice(ActionEvent event) {
        Restaurant restaurantSelected = restaurantList.getSelectionModel().getSelectedItem();
        if (restaurantSelected != null) {
            float avgPrice = restaurantSelected.avgPrice();
            avgPriceTextLabel.setText(String.format("%s: $%.2f", restaurantSelected.m_name, avgPrice));
        }
    }
    
    @FXML
    private void getAvgCalPerDollar(ActionEvent event) {
        Restaurant restaurantSelected = restaurantList.getSelectionModel().getSelectedItem();
        if (restaurantSelected != null) {
            int avgCalPerDollar = restaurantSelected.avgCaloriesPerDollar();
            avgCalPerDollarTextLabel.setText(String.format("%s: %d/$", restaurantSelected.m_name, avgCalPerDollar));
        }
    }
    
    @FXML
    private void getValueMealFor(ActionEvent event) {
        if (getValueMealForTextBox.getText().isEmpty()) {
            throw new EmptyTextBoxException();
        }
        Restaurant restaurantSelected = restaurantList.getSelectionModel().getSelectedItem();
        if (restaurantSelected != null) {
            valueMealForList.getItems().clear();
            switch((String)getValueMealForChoiceBox.getValue()) {
                case "dollars" -> { 
                    valueMealForList.getItems().addAll(restaurantSelected.getValueMealForDollars(Float.parseFloat(getValueMealForTextBox.getText()),'d'));
                }
                case "dollars (breakfast)" -> {
                    valueMealForList.getItems().addAll(restaurantSelected.getValueMealForDollars(Float.parseFloat(getValueMealForTextBox.getText()),'b'));
                }
                case "calories" -> {
                    valueMealForList.getItems().addAll(restaurantSelected.getValueMealForCalories(Integer.parseInt(getValueMealForTextBox.getText()),'d'));
                }
                case "calories (breakfast)" -> {
                    valueMealForList.getItems().addAll(restaurantSelected.getValueMealForCalories(Integer.parseInt(getValueMealForTextBox.getText()),'b'));
                }
            }
        }
    }
}
