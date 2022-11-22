package com.example.maintermprojectjavafx;

import database.ReadData;
import equipment.Equipment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateEquipmentAppl implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Equipment> EquipTable;
    @FXML
    private TableColumn<Equipment,String> name = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> material = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> cost = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> weight = new TableColumn<>();
    @FXML
    private TableColumn<Equipment, Double> strength = new TableColumn<>();
    @FXML
    private TableColumn<Equipment,String> typeofarmor = new TableColumn<>();
    public void buttonEquipment(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateExistedEquipment.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registration");
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
    public void chooseEquip(ActionEvent event){
        int Id = EquipTable.getSelectionModel().getSelectedIndex();

    }
    public void SubmitUpdateEquip(ActionEvent event){

    }
    public void buttonWeapon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateExistedWeapon.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }
    public void buttonGetData(ActionEvent event) throws IOException{
        ReadData readData=new ReadData();
        ObservableList<Equipment> equipment = readData.readEquipForTable();
        EquipTable.setItems(equipment);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<Equipment,String>("name"));
        material.setCellValueFactory(new PropertyValueFactory<Equipment,String>("material"));
        cost.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("cost"));
        weight.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("weight"));
        strength.setCellValueFactory(new PropertyValueFactory<Equipment,Double>("strength"));
        typeofarmor.setCellValueFactory(new PropertyValueFactory<Equipment,String>("typeofarmour"));
    }
}
