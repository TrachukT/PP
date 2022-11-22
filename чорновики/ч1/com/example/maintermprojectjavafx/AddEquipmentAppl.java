package com.example.maintermprojectjavafx;

import data.EquipList;
import database.ReadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.IOException;

public class AddEquipmentAppl {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField name;
    @FXML
    TextField material;
    @FXML
    TextField cost;
    @FXML
    TextField weight;
    @FXML
    TextField strength;
    @FXML
    TextField typeOfArmour;
    @FXML
    Label Information;
    public void buttonEquipment(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("AddNewEquip.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add equipment");
        stage.setScene(scene);
        stage.show();
    }
    public void addEquipmentSubmit(){
        String nameText = name.getText();
        String materialText = material.getText();
        double costText = Double.parseDouble(cost.getText());
        System.out.println(costText);
        double weightText = Double.parseDouble(weight.getText());
        double strengthText = Double.parseDouble(strength.getText());
        String typeText = typeOfArmour.getText();
        ReadData readData=new ReadData();
        EquipList equipList = new EquipList();
        readData.readEquip(equipList);
        if(equipList.checkForCopy(nameText,materialText,costText,weightText,strengthText,typeText)){
            Information.setMinWidth(500);
            Information.setText("There is already identical part of equipment in the database");
            return;
        }
        else if(equipList.checkNameDublication(nameText)){
            Information.setMinWidth(500);
            Information.setText("There is an equip with the exact name.\nPlease enter other name");
        }
        else {
            equipList.addEquipFromInterface(nameText, materialText, costText, weightText, strengthText, typeText);
            equipList.printList();
            Information.setMinWidth(500);
            Information.setText("Equipment added successfully");
        }
    }
    public void  buttonWeapon(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("addNewWeapon.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Add weapon");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBackFromAdding(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log into system");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log into system");
        stage.setScene(scene);
        stage.show();
    }
}
