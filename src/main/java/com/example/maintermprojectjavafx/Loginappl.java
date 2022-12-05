package com.example.maintermprojectjavafx;

import data.*;
import database.ReadData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loginappl {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label error;
    @FXML
    TextField email;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label wronguser;
    private AllDataInterface allDataInterface=new AllDataInterface();
//    public void  switchLogin(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("login.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setTitle("Log into system");
//        stage.setScene(scene);
//    }
    private ReadData readData=new ReadData();
    private List<EquipList> knightsequip=new ArrayList<>();
    private List<WeaponList> knightsweapon = new ArrayList<>();
    private KnightInfo knightInfo=new KnightInfo();
    private EquipList equipList=new EquipList();
    private WeaponList weaponList=new WeaponList();
    public void switchSubmit(ActionEvent  event) throws IOException {
        String emailText = email.getText();
        String usernameText = username.getText();
        String passwordText = password.getText();
        Loginlist usersdata = new Loginlist();
        Login user=new Login(usernameText,passwordText,emailText);
        readData.readLogins(usersdata);
        if(usersdata.finduser(user)) {
            readData.readWeapon(weaponList);
            readData.readEquip(equipList);
            readData.readKnights(knightInfo);
            error.setText("");
            AllDataInterface.setUser(user);
            readData.readKnightsEquipment(readData.userid(usersdata,user),knightInfo,equipList,knightsequip);
            readData.readKnightsWeapon(readData.userid(usersdata,user),knightInfo,weaponList,knightsweapon);
            AllDataInterface.setKnightInfo(knightInfo);
            AllDataInterface.setKnightsEquip(knightsequip);
            AllDataInterface.setKnightsWeapon(knightsweapon);
            switchMenuOfActions(event);
        }
        else if (usersdata.checkpassword(user)){
            error.setMinWidth(300);
            error.setText("Wrong password");
        }
        else {
            error.setText("");
            wronguser.setMinWidth(320);
            wronguser.setMinHeight(33);
            wronguser.setText("User with such data not registered.\nPlease press button \"Back\" and firstly register in the base");
            //switchBack(event);
        }
    }
    public void switchMenuOfActions(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu of actions");
        stage.setScene(scene);
        stage.show();
    }
    public void switchBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log into system");
        stage.setScene(scene);
        stage.show();
    }
}
