package com.example.maintermprojectjavafx;

import data.EquipList;
import data.WeaponList;
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
import weapon.Lance;

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
    @FXML
    Label Label1;
    @FXML
    Label Label2;
    @FXML
    TextField nameweapon;
    @FXML
    TextField weightWeapon;
    @FXML
    TextField costWeapon;
    @FXML
    TextField damageWeapon;
    @FXML
    TextField modified1;
    @FXML
    TextField modified2;
    @FXML
    Label error;
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
       // System.out.println(costText);
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
    public void ButtonAxe(ActionEvent event){
        Label1.setText("Blade shape");
        modified1.setVisible(true);
        Label2.setText("");
        modified2.setVisible(false);
    }
    public void ButtonBow(ActionEvent event){
        Label1.setText("Amount of arrows");
        modified1.setVisible(true);
        Label2.setText("Type of bowstring");
        modified2.setVisible(true);
    }
    public void ButtonLance(ActionEvent event){
        Label1.setText("Length of lance");
        modified1.setVisible(true);
        Label2.setText("");
        modified2.setVisible(false);
    }
    public void ButtonSword(ActionEvent event){
        Label1.setText("Type of blade");
        modified1.setVisible(true);
        Label2.setText("");
        modified2.setVisible(false);
    }
    public void ButtonKnife(ActionEvent event){
        Label1.setText("Type of knife");
        modified1.setVisible(true);
        Label2.setText("");
        modified2.setVisible(false);
    }
    public void addWeaponSubmit(ActionEvent event){
        String nameT = nameweapon.getText();
        if(Label1.getText().equals("")){
            error.setText("You didn`t choose the type");
            return;
        }
        error.setText("");
        double weightT = Double.parseDouble(weightWeapon.getText());
        double costT = Double.parseDouble(costWeapon.getText());
        double damageT = Double.parseDouble(damageWeapon.getText());
        String modifiedT;
        int modifiednumber;
        WeaponList weaponList=new WeaponList();
        ReadData readData=new ReadData();
        readData.readWeapon(weaponList);
        //System.out.println(Label1.getText());
        switch (Label1.getText()) {
            case "Type of knife" -> {
                if (checkingName(weaponList,nameT))
                    break;
                modifiedT = modified1.getText();
                weaponList.addKnife(nameT, weightT, costT, damageT, modifiedT);
                error.setText("Weapon added successfully");
            }
            case "Blade shape" -> {
                if (checkingName(weaponList,nameT))
                    break;
                modifiedT = modified1.getText();
                weaponList.addAxe(nameT, weightT, costT, damageT, modifiedT);
                error.setText("Weapon added successfully");
            }
            case "Length of lance" -> {
                if (checkingName(weaponList,nameT))
                    break;
                modifiednumber = Integer.parseInt(modified1.getText());
                weaponList.addLance(nameT, weightT, costT, damageT, modifiednumber);
                error.setText("Weapon added successfully");
            }
            case "Type of blade" -> {
                if (checkingName(weaponList,nameT))
                    break;
                modifiedT = modified1.getText();
                weaponList.addSword(nameT, weightT, costT, damageT, modifiedT);
                error.setText("Weapon added successfully");
            }
            case "Amount of arrows" -> {
                if (checkingName(weaponList,nameT))
                    break;
                modifiednumber = Integer.parseInt(modified1.getText());
                modifiedT = modified2.getText();
                weaponList.addBow(nameT, weightT, costT, damageT, modifiednumber, modifiedT);
                error.setText("Weapon added successfully");
            }
            default -> error.setText("You didn`t choose the type");
        }
    }
    public boolean checkingName(WeaponList weaponList,String name){
        if(weaponList.checkName(name)){
            error.setText("There is already weapon with this name");
            return  true;
        }
        return false;
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
        root = FXMLLoader.load(getClass().getResource("addequipment.fxml"));
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
