package com.example.maintermprojectjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

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
//    public void switchExit(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Exit");
//        alert.setContentText("Do you want to exit?");
//        if(alert.showAndWait().get() == ButtonType.OK)
//        {
//            System.out.println("You are exited");
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.close();
//        }
//    }
//    public void switchRegistration(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("registration.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setTitle("Registration");
//        stage.setScene(scene);
//        stage.show();
//    }
    public void buttonLogOut(ActionEvent event) throws IOException {
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
