package com.example.maintermprojectjavafx;

import data.AllDataInterface;
import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import database.ReadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu2 {
    private Stage stage;
    private Scene scene;
    private Parent root;

//    public void switchInfo(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("Info.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setTitle("KnightsInfo");
//        stage.setScene(scene);
//        stage.show();
//    }
    public  void buttonUpdateEquipment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("updateEquipment.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonBuildReport(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("buildReport.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.show();
    }
    public void buttonSelectEquipment(ActionEvent event)throws  IOException{
        root = FXMLLoader.load(getClass().getResource("SelectKnightforEquip.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select knight");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonSelectWeapon(ActionEvent event)throws  IOException{
        root = FXMLLoader.load(getClass().getResource("SelectKnightforWeapon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select knight");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonDelete(ActionEvent event)throws IOException{
        root = FXMLLoader.load(getClass().getResource("SelectKnightForDelete.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Select knight");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonLogOut(ActionEvent event) throws IOException {
//        KnightInfo knightInfo=new KnightInfo();
//        AllDataInterface.setKnightInfo(knightInfo);
//        List<EquipList> knightequip = new ArrayList<>();
//        AllDataInterface.setKnightsEquip(knightequip);
//        List<WeaponList> knightweapon = new ArrayList<>();
//        AllDataInterface.setKnightsWeapon(knightweapon);
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Knights");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonAddEquipment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addequipment.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Adding equipment");
        stage.setScene(scene);
        stage.show();
    }
}
